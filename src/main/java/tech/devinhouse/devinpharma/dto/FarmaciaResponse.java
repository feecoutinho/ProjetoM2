package tech.devinhouse.devinpharma.dto;

import tech.devinhouse.devinpharma.model.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class FarmaciaResponse {

    private Long cnpj;

    private String razaoSocial;

    private String nomeFantasia;

    private String email;

    private String telefone;

    private String celular;

    private Endereco endereco;

    }
