package tech.devinhouse.devinpharma.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.devinpharma.dto.EstoqueResponse;
import tech.devinhouse.devinpharma.dto.FarmaciaResponse;
import tech.devinhouse.devinpharma.model.Estoque;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.services.EstoqueService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/estoques/{cnpj}")
    public ResponseEntity<?> consultarEstoque(@PathVariable("cnpj") Long cnpj){
        try {
            List<Estoque> estoques = estoqueService.consultar(cnpj);
            List<EstoqueResponse> resp = new ArrayList<EstoqueResponse>();
            for (Estoque estoque : estoques){
                EstoqueResponse r = mapper.map(estoque, EstoqueResponse.class);
                resp.add(r);
            }
            return ResponseEntity.ok(resp);
        }
        catch(Exception e) {
            return new ResponseEntity<String>("A farmacia " + cnpj + " não existe em nossa base ou a conexão falhou por outro motivo.", HttpStatusCode.valueOf(404));
        }
    }
}
