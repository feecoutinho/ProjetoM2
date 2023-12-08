package tech.devinhouse.devinpharma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.devinpharma.model.Medicamento;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EstoqueResponse {

    private Medicamento medicamento;

    private Integer quantidade;

    private LocalDateTime dataAtualizacao;
}
