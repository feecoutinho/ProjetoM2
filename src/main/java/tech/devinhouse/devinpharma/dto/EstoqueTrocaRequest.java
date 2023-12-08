package tech.devinhouse.devinpharma.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EstoqueTrocaRequest {

    @NotNull(message = "Campo obrigatório.")
    private Long cnpjOrigem;

    @NotNull(message = "Campo obrigatório.")
    private Long cnpjDestino;

    @NotNull(message = "Campo obrigatório.")
    private Integer nroRegistro;

    @NotNull(message = "Campo obrigatório.")
    private Integer quantidade;
}