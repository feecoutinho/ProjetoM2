package tech.devinhouse.devinpharma.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FARMACIAS")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Farmacia {

    @Id
    private Long cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    private String email;

    private String telefone;

    private String celular;

    @Embedded
    private Endereco endereco;

}


