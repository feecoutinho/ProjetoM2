package tech.devinhouse.devinpharma.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharma.dto.EstoqueFarmaciaResponse;
import tech.devinhouse.devinpharma.dto.EstoqueRequest;
import tech.devinhouse.devinpharma.dto.EstoqueResponse;
import tech.devinhouse.devinpharma.dto.FarmaciaResponse;
import tech.devinhouse.devinpharma.model.Estoque;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.services.EstoqueService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/estoque/{cnpj}")
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

    @PostMapping("/estoque")
    public ResponseEntity<?> AdquirirMedParaEstoque(@RequestBody @Valid EstoqueRequest request) {
        Estoque estoque = estoqueService.adquirirEstoque(request.getCnpj(), request.getNroRegistro(), request.getQuantidade(), LocalDateTime.now());
        var resp = new EstoqueFarmaciaResponse(estoque.getFarmacia().getCnpj(), estoque.getMedicamento().getNroRegistro(), estoque.getQuantidade());
        return ResponseEntity.ok(resp);
    }
}
