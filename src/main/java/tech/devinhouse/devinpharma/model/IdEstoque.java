package tech.devinhouse.devinpharma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IdEstoque implements java.io.Serializable {

    private Farmacia farmacia;

    private Medicamento medicamento;
}
