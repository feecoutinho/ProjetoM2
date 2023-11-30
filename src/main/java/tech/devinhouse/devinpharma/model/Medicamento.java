package tech.devinhouse.devinpharma.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEDICAMENTOS")
@AllArgsConstructor
@NoArgsConstructor

public class Medicamento {

    @Id
    private Integer nroRegistro;

    private String nome;

    private String laboratorio;

    private String dosagem;

    private String descricao;

    private Float preco;

    @Enumerated(EnumType.STRING)
    private TipoMedicamento tipo;

}
