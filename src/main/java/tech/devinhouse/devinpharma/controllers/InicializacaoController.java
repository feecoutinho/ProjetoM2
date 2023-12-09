package tech.devinhouse.devinpharma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharma.model.*;
import tech.devinhouse.devinpharma.services.EstoqueService;
import tech.devinhouse.devinpharma.services.FarmaciaService;
import tech.devinhouse.devinpharma.services.MedicamentoService;

import java.time.LocalDateTime;


@RestController
@RequestMapping

public class InicializacaoController {

    @Autowired
    private FarmaciaService farmaciaService;

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/inicializacao")
    public ResponseEntity<?> carregarDados() {
        var farmacias = farmaciaService.consultar();
        if (farmacias.isEmpty()) {
            Farmacia farmacia1 = new Farmacia(90561736000121L, "DevMed-Ltda", "Farmácia-DevMed", "devmed@farmacia.com", "(44)4444-4444", "(44)9444-4441",new Endereco(88888999,"Rua-Porto-Real",67,"Westeros","Berlim","SC","Esquina",15.23456,2.8678687));
            Farmacia farmacia2 = new Farmacia(43178995000198L,"MedHouse-Ltda", "Farmacia-MedHouse", "medhouse@farmacia.com","(55)5555-5555","(45)95555-5555",new Endereco(88777999, "Rua-Madrid", 76, "Winterfell", "Estocolmo", "SC","Fundos",19.254356,3.8987687));

            farmaciaService.salvar(farmacia1);
            farmaciaService.salvar(farmacia2);

        }

        var medicamentos = medicamentoService.consultar();
        if (medicamentos.isEmpty()){
            Medicamento medicamento1 = new Medicamento(1010, "Programapan", "Matrix", "2x ao dia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunmc eleifend", 111.00f, TipoMedicamento.COMUM);
            Medicamento medicamento2 = new Medicamento(7473, "Cafex", "Colombia Farm", "4x ao dia", "Pellentesque non ultricies mauris, ut lobortis elit. Cras nec cursus nibh", 51.50f, TipoMedicamento.COMUM);
            Medicamento medicamento3 = new Medicamento(2233, "Estomazol", "Acme", "1x ao dia", "Sed risus mauris, consectetur eget egestas vitae", 22.50f, TipoMedicamento.COMUM);
            Medicamento medicamento4 = new Medicamento(8880, "Gelox", "Ice", "2x ao dia", "Quisque quam orci, vulputate sit amet", 11.50f, TipoMedicamento.COMUM);
            Medicamento medicamento5 = new Medicamento(5656, "Aspirazol", "Acme", "3x ao dia", "Sed faucibus, libero iaculis pulvinar consequat, augue elit eleifend", 10.50f, TipoMedicamento.CONTROLADO);
            Medicamento medicamento6 = new Medicamento(4040, "Propolizol", "Bee", "5x ao dia", "Nunc euismod ipsum purus, sit amet finibus libero ultricies in", 10.50f, TipoMedicamento.CONTROLADO);

            medicamentoService.salvar(medicamento1);
            medicamentoService.salvar(medicamento2);
            medicamentoService.salvar(medicamento3);
            medicamentoService.salvar(medicamento4);
            medicamentoService.salvar(medicamento5);
            medicamentoService.salvar(medicamento6);
        }

        var estoque = estoqueService.consultar();
        if (estoque.isEmpty()){

            estoqueService.cadastrarEstoque(90561736000121L, 1010, 12, LocalDateTime.now());
            estoqueService.cadastrarEstoque(90561736000121L, 7473, 10, LocalDateTime.now());
            estoqueService.cadastrarEstoque(43178995000198L, 7473, 2, LocalDateTime.now());
            estoqueService.cadastrarEstoque(43178995000198L, 2233, 15, LocalDateTime.now());
            estoqueService.cadastrarEstoque(43178995000198L, 8880, 16, LocalDateTime.now());
            estoqueService.cadastrarEstoque(43178995000198L, 4040, 22, LocalDateTime.now());
        }

        return ResponseEntity.ok().build();
    }

}
