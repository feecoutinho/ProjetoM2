package tech.devinhouse.devinpharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.devinpharma.model.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
}