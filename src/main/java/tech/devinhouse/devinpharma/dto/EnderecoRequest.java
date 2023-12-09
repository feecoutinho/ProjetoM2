package tech.devinhouse.devinpharma.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoRequest {

    @NotNull(message = "Campo obrigatório.")
    private Integer cep;

    @NotNull(message = "Campo obrigatório.")
    private String logradouro;

    @NotNull(message = "Campo obrigatório.")
    private Integer numero;

    @NotBlank(message = "Campo obrigatório.")
    private String bairro;

    @NotBlank(message = "Campo obrigatório.")
    private String cidade;

    @NotBlank(message = "Campo obrigatório.")
    private String estado;

    private String complemento;

    @NotNull(message = "Campo obrigatório.")
    private Double latitude;

    @NotNull(message = "Campo obrigatório.")
    private Double longitude;
}