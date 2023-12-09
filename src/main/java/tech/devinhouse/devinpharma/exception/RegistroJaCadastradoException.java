package tech.devinhouse.devinpharma.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RegistroJaCadastradoException extends RuntimeException {

    private String nome;

    private String identificador;


    public RegistroJaCadastradoException(String nome, Integer identificador) {
        this(nome, identificador.toString());
    }

    public RegistroJaCadastradoException(String nome, Long identificador) {
        this(nome, identificador.toString());
    }


    public String getMessage() {
        if (nome == null || identificador == null)
            return null;
       // return String.format("Registro '%s' já cadastrado com identificador '%s'", nome, identificador);
        if (nome == "Farmacia")
           return String.format("A farmacia de cnpj %s já existe", identificador);

        if (nome == "Medicamento")

            return String.format("O medicamento de número %s já existe", identificador);
        return "Verificar com o suporte.";
    }

}