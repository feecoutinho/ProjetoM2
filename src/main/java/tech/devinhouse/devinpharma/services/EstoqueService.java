package tech.devinhouse.devinpharma.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharma.exception.EstoqueInexistenteException;
import tech.devinhouse.devinpharma.exception.QuantidadeInvalidaException;
import tech.devinhouse.devinpharma.model.Estoque;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.model.Medicamento;
import tech.devinhouse.devinpharma.model.IdEstoque;
import tech.devinhouse.devinpharma.repository.EstoqueRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepo;

    @Autowired
    private FarmaciaService farmaciaService;

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private ModelMapper mapper;

    public List<Estoque> consultar() {
        return estoqueRepo.findAll();
    }

    public List<Estoque> consultar(Long cnpj) {
        Farmacia farma = farmaciaService.consultar(cnpj);
        return estoqueRepo.findAllByFarmacia(farma);
    }


    public Estoque cadastrarEstoque(Long cnpj, Integer nroRegistro, Integer qty, LocalDateTime data) {
        Farmacia farma = farmaciaService.consultar(cnpj);
        Medicamento med = medicamentoService.consultar(nroRegistro);
        Estoque estoque = new Estoque(farma, med, qty, data);

        estoque = estoqueRepo.save(estoque);
        return estoque;
    }

    public Estoque adquirirEstoque(Long cnpj, Integer nroRegistro, Integer qty, LocalDateTime data) {
        Farmacia farma = farmaciaService.consultar(cnpj);
        Medicamento med = medicamentoService.consultar(nroRegistro);
        if (qty <= 0){
            throw new QuantidadeInvalidaException(qty);
        }
        IdEstoque id = new IdEstoque(farma, med);
        if (!(estoqueRepo.existsById(id))) {
            Estoque estoque = new Estoque(farma, med, qty, data);
            estoque = estoqueRepo.save(estoque);
            return estoque;
        }
        Estoque estoque = estoqueRepo.getReferenceById(id);
        estoque.setQuantidade(estoque.getQuantidade()+qty);
        estoque.setDataAtualizacao(data);
        estoque = estoqueRepo.save(estoque);
        return estoque;
    }

    public Estoque venderEstoque(Long cnpj, Integer nroRegistro, Integer qty, LocalDateTime data) {
        Farmacia farma = farmaciaService.consultar(cnpj);
        Medicamento med = medicamentoService.consultar(nroRegistro);
        if (qty <= 0){
            throw new QuantidadeInvalidaException(qty);
        }

        IdEstoque id = new IdEstoque(farma, med);
        if (!(estoqueRepo.existsById(id))) {
            throw new EstoqueInexistenteException();
        }
        Estoque estoque = estoqueRepo.getReferenceById(id);
        if (qty > estoque.getQuantidade()){
            throw new QuantidadeInvalidaException(qty);
        }
        estoque.setQuantidade(estoque.getQuantidade()-qty);
        estoque.setDataAtualizacao(data);
        if (estoque.getQuantidade() == 0){
            estoqueRepo.delete(estoque);
            return estoque;
        }
        estoque = estoqueRepo.save(estoque);
        return estoque;
    }

    public List<Estoque> trocaEstoque(Long cnpjOrigem, Long cnpjDestino, Integer nroRegistro, Integer qty, LocalDateTime data) {
        // Checa existencia dos dados
        farmaciaService.consultar(cnpjOrigem);
        farmaciaService.consultar(cnpjDestino);
        medicamentoService.consultar(nroRegistro);
        // Chama "adicionar" e "subtrair" medicamento do estoque
        Estoque EstoqueOrigem = venderEstoque(cnpjOrigem, nroRegistro, qty, data);
        Estoque EstoqueDestino = adquirirEstoque(cnpjDestino, nroRegistro, qty, data);
        return Arrays.asList(EstoqueOrigem, EstoqueDestino);
    }

}


