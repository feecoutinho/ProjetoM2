package tech.devinhouse.devinpharma.dto;


import lombok.Data;

@Data
public class EstoqueFarmaciaResponse {

    private Long cnpj;

    private Integer nroRegistro;

    private Integer quantidade;
}
