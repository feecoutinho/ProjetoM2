package tech.devinhouse.devinpharma.model;

public class IdEstoque implements java.io.Serializable {
    private Farmacia farmacia;
    private Medicamento medicamento;

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
}
