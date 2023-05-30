package fr.associationrdj.backend.back.coordonnee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordonneeRepository extends JpaRepository<Coordonnee, Long> {
}
