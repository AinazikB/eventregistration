package alatoo.kg.eventregistration.repositories;

import alatoo.kg.eventregistration.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByConfirmationToken(String token);
}
