package tech.devinhouse.devinpharma.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ESTOQUES")
@IdClass(IdEstoque.class)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Estoque {

    @ManyToOne
    @JoinColumn(name = "cnpj", referencedColumnName = "cnpj")
    @Id
    private Farmacia farmacia;

    @ManyToOne
    @JoinColumn(name = "nroRegistro", referencedColumnName = "nroRegistro")
    @Id
    private Medicamento medicamento;

    private Integer quantidade;

    private LocalDateTime dataAtualizacao;

}

