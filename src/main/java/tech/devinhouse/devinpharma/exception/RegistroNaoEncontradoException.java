package tech.devinhouse.devinpharma.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class RegistroNaoEncontradoException extends RuntimeException {

    private String nome;
    private String identificador;


    public RegistroNaoEncontradoException(String nome, Integer identificador) {

        this(nome, identificador.toString());
    }

    public RegistroNaoEncontradoException(String nome, Long identificador) {

        this(nome, identificador.toString());
    }


    public String getMessage() {
        if (nome == null || identificador == null)
            return null;
        //return String.format("Registro '%s' nao encontrado com identificador '%s'", nome, identificador);

        if (nome == "Farmacia")
            return String.format("A farmacia de cnpj %s não existe", identificador);

        if (nome == "Medicamento")

            return String.format("O medicamento de número %s não existe", identificador);
        return "Verificar com o suporte.";
    }

}
