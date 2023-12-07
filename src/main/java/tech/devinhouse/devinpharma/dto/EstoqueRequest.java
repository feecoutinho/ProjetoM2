package tech.devinhouse.devinpharma.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EstoqueRequest {

    @NotNull(message = "Campo obrigatório.")
    private Long cnpj;

    @NotNull(message = "Campo obrigatório.")
    private Integer nroRegistro;

    @NotNull(message = "Campo obrigatório.")
    private Integer quantidade;
}
