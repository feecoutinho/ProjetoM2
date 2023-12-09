package tech.devinhouse.devinpharma.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.devinpharma.model.TipoMedicamento;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedRequest {

    @NotNull(message = "Campo obrigatório.")
    private Integer nroRegistro;

    @NotBlank(message = "Campo obrigatório.")
    private String nome;

    @NotBlank(message = "Campo obrigatório.")
    private String laboratorio;

    @NotNull(message = "Campo obrigatório.")
    private String dosagem;

    private String descricao;

    @NotNull(message = "Campo obrigatório.")
    private Float preco;

    @NotNull(message = "Campo obrigatório.")
    @Enumerated(EnumType.STRING)
    private TipoMedicamento tipo;

}
