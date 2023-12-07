package tech.devinhouse.devinpharma.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharma.model.Medicamento;
import tech.devinhouse.devinpharma.repository.MedicamentoRepository;

import java.util.List;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medRepo;

    @Autowired
    private ModelMapper mapper;

    public List<Medicamento> consultar() {

        return medRepo.findAll();
    }

    public Medicamento consultar(Integer Nro) {
        return medRepo.findById(Nro)
                .orElseThrow(() -> new ArrayIndexOutOfBoundsException("Não encontrado medicamento com numero: " + Nro));
    }

    public boolean checaSeExiste(Integer Nro) {
        return medRepo.existsById(Nro);
    }

    public Medicamento salvar(Medicamento medicamento) {
        boolean existe = medRepo.existsById(medicamento.getNroRegistro());

        medicamento = medRepo.save(medicamento);
        return medicamento;
    }


}
