package tech.devinhouse.devinpharma.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstoqueFarmaciaResponse {

    private Long cnpj;

    private Integer nroRegistro;

    private Integer quantidade;
}
