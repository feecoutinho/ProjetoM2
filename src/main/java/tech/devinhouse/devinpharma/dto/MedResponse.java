package tech.devinhouse.devinpharma.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.devinpharma.model.TipoMedicamento;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedResponse {


    private Integer nroRegistro;

    private String nome;

    private String laboratorio;

    private String dosagem;

    private String descricao;

    private Float preco;

    @Enumerated(EnumType.STRING)
    private TipoMedicamento tipo;

}
