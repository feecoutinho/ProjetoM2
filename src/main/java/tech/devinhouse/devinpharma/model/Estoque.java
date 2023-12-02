package tech.devinhouse.devinpharma.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ESTOQUES")
@IdClass(IdEstoque.class)
@Data

public class Estoque {

    @ManyToOne
    @JoinColumn(name = "cnpj")
    @Id
    private Farmacia farmacia;

    @ManyToOne
    @JoinColumn(name = "nroRegistro")
    @Id
    private Medicamento medicamento;

    private Integer quantidade;

    private LocalDateTime dataAtualizacao;

}

