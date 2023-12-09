package tech.devinhouse.devinpharma.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharma.dto.MedRequest;
import tech.devinhouse.devinpharma.dto.MedResponse;
import tech.devinhouse.devinpharma.exception.RegistroJaCadastradoException;
import tech.devinhouse.devinpharma.model.Medicamento;
import tech.devinhouse.devinpharma.services.MedicamentoService;

import java.net.URI;
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

    @PostMapping("/medicamentos")
    public ResponseEntity<?> registrarMedicamento(@RequestBody @Valid MedRequest request) {
        Medicamento medicamento = mapper.map(request, Medicamento.class);
        if (medicamentoService.checaSeExiste(medicamento.getNroRegistro())) {
            throw new RegistroJaCadastradoException("Medicamento", medicamento.getNroRegistro());
        }

        medicamentoService.salvar(medicamento);
        var resp = mapper.map(medicamento, MedResponse.class);
        return ResponseEntity.created(URI.create(medicamento.getNroRegistro().toString())).body(resp);
    }
}
