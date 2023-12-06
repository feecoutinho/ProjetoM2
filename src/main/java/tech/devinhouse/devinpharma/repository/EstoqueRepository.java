package tech.devinhouse.devinpharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devinpharma.model.Estoque;
import tech.devinhouse.devinpharma.model.Farmacia;
import tech.devinhouse.devinpharma.model.IdEstoque;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, IdEstoque> {

    List<Estoque> findAllByFarmacia(Farmacia farmacia);
}
