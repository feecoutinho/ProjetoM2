package tech.devinhouse.devinpharma.services;

import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.repository.FarmaciaRepository;

import java.util.List;

@Service
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepo;

    @Autowired
    private ModelMapper mapper;

    public List<Farmacia> consultar() {
        return farmaciaRepo.findAll();
    }

    public Farmacia consultar(Long cnpj) {
        return farmaciaRepo.findById(cnpj)
        .orElseThrow(() -> new RuntimeException ("Farmacia não encontrada"));
    }

    public Farmacia salvar(@NotNull Farmacia farmacia) {
        boolean existe = farmaciaRepo.existsById(farmacia.getCnpj());
        //if (existe)
            //throw new RegistroJaExistenteException("Veiculo", veiculo.getPlaca());
        farmacia = farmaciaRepo.save(farmacia);
        return farmacia;
    }

}
