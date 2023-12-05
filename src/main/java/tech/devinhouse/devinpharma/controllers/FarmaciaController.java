package tech.devinhouse.devinpharma.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharma.dto.FarmaciaResponse;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.services.FarmaciaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/farmacias")
    public ResponseEntity<List<FarmaciaResponse>> consultarFarmacias() {
        List<Farmacia> farmacias = farmaciaService.consultar();
        List<FarmaciaResponse> resp = new ArrayList<FarmaciaResponse>();
        for (Farmacia farmacia : farmacias){
            FarmaciaResponse r = mapper.map(farmacia, FarmaciaResponse.class);
            resp.add(r);
        }
        return ResponseEntity.ok(resp);
    }

    @GetMapping("farmacias/{cnpj}")
    public ResponseEntity<?> consultarFarmacia(@PathVariable("cnpj") Long cnpj){
        try {
            Farmacia farmacia = farmaciaService.consultar(cnpj);
            return ResponseEntity.ok(mapper.map(farmacia, FarmaciaResponse.class));
        }
        catch(Exception e) {
            return new ResponseEntity<String>("A farmacia " + cnpj + " não existe em nossa base ou a conexão falhou por outro motivo.", HttpStatusCode.valueOf(404));
        }
    }

    }

