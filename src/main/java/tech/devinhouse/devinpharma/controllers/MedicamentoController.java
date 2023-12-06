package tech.devinhouse.devinpharma.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharma.dto.MedResponse;
import tech.devinhouse.devinpharma.model.Medicamento;
import tech.devinhouse.devinpharma.services.MedicamentoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/medicamentos")
    public ResponseEntity<List<MedResponse>> consultarMedicamentos() {
        List<Medicamento> medicamentos = medicamentoService.consultar();
        List<MedResponse> resp = new ArrayList<MedResponse>();
        for (Medicamento medicamento : medicamentos){
            MedResponse r = mapper.map(medicamento, MedResponse.class);
            resp.add(r);
        }
        return ResponseEntity.ok(resp);
    }
}
