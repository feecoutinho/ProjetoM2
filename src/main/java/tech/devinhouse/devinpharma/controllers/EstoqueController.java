package tech.devinhouse.devinpharma.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.devinpharma.dto.*;
import tech.devinhouse.devinpharma.model.Estoque;
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


            List<Estoque> estoques = estoqueService.consultar(cnpj);
            List<EstoqueResponse> resp = new ArrayList<EstoqueResponse>();
            for (Estoque estoque : estoques){
                EstoqueResponse r = mapper.map(estoque, EstoqueResponse.class);
                resp.add(r);
            }
            return ResponseEntity.ok(resp);

    }

    @PostMapping("/estoque")
    public ResponseEntity<?> AdquirirMedParaEstoque(@RequestBody @Valid EstoqueRequest request) {
        Estoque estoque = estoqueService.adquirirEstoque(request.getCnpj(), request.getNroRegistro(), request.getQuantidade(), LocalDateTime.now());
        var resp = new EstoqueFarmaciaResponse(estoque.getFarmacia().getCnpj(), estoque.getMedicamento().getNroRegistro(), estoque.getQuantidade());
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/estoque")
    public ResponseEntity<?> VenderMedDoEstoque(@RequestBody @Valid EstoqueRequest request) {
        Estoque estoque = estoqueService.venderEstoque(request.getCnpj(), request.getNroRegistro(), request.getQuantidade(), LocalDateTime.now());
        var resp = new EstoqueFarmaciaResponse(estoque.getFarmacia().getCnpj(), estoque.getMedicamento().getNroRegistro(), estoque.getQuantidade());
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/estoque")
    public ResponseEntity<EstoqueTrocaResponse> TrocaDeEstoque(@RequestBody @Valid EstoqueTrocaRequest request) {
        List<Estoque> estoques = estoqueService.trocaEstoque(request.getCnpjOrigem(), request.getCnpjDestino(), request.getNroRegistro(), request.getQuantidade(), LocalDateTime.now());
        Estoque estoqueOrigem = estoques.get(0);
        Estoque estoqueDestino = estoques.get(1);
        var resp = new EstoqueTrocaResponse();
        resp.setRegistro(request.getNroRegistro());
        resp.setCnpjOrigem(estoqueOrigem.getFarmacia().getCnpj());
        resp.setQuantidadeOrigem(estoqueOrigem.getQuantidade());
        resp.setCnpjDestino(estoqueDestino.getFarmacia().getCnpj());
        resp.setQuantidadeDestino(estoqueDestino.getQuantidade());
        return ResponseEntity.ok(resp);
    }
}
