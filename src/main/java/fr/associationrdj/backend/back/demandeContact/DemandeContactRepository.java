package fr.associationrdj.backend.back.demandeContact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeContactRepository extends JpaRepository<DemandeContact,Long> {
}
