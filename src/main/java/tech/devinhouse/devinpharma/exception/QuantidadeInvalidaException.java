package tech.devinhouse.devinpharma.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class QuantidadeInvalidaException extends RuntimeException {

    private String quantidade;

    public QuantidadeInvalidaException(Integer quantidade) {
        this(quantidade.toString());
    }

    public String getMessage() {
        if (quantidade == null)
            return null;
        return String.format("Quantidade '%s' é inválida.'", quantidade);
    }

}
