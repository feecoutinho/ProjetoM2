package tech.devinhouse.devinpharma.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FarmaciaRequest {

    @NotNull(message = "Campo obrigatório.")
    private Long cnpj;

    @NotBlank(message = "Campo obrigatório.")
    private String razaoSocial;

    @NotBlank(message = "Campo obrigatório.")
    private String nomeFantasia;

    @NotBlank(message = "Campo obrigatório.")
    private String email;

    private String telefone;

    @NotNull(message = "Campo obrigatório.")
    private String celular;

    @NotNull(message = "Campo obrigatório.")
    private EnderecoRequest endereco;
}
