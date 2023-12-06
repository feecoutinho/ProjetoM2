package tech.devinhouse.devinpharma.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharma.model.Estoque;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.model.Medicamento;
import tech.devinhouse.devinpharma.model.IdEstoque;
import tech.devinhouse.devinpharma.repository.EstoqueRepository;

import java.time.LocalDateTime;
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



}


