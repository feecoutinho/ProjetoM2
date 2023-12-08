package tech.devinhouse.devinpharma.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class EstoqueInexistenteException extends RuntimeException {

    public String getMessage() {
        return "Medicamento não existe em nosso estoque.";
    }
}
