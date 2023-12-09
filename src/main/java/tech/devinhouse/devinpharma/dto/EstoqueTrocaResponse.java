package tech.devinhouse.devinpharma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstoqueTrocaResponse {
    private Integer registro;

    private Long cnpjOrigem;

    private Integer quantidadeOrigem;

    private Long cnpjDestino;

    private Integer quantidadeDestino;
}