package tech.devinhouse.devinpharma.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharma.model.Estoque;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.model.Medicamento;
import tech.devinhouse.devinpharma.repository.EstoqueRepository;

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

    public Estoque cadastrarEstoque(Long cnpj, Integer nroRegistro, Estoque estoque) {
        var farmacia = this.consultar();
        var medicamento = this.consultar();
        estoque = estoqueRepo.save(estoque);
        return estoque;
    }
}


