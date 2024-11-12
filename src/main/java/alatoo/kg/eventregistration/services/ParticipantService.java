package alatoo.kg.eventregistration.services;
import alatoo.kg.eventregistration.entities.Participant;
import alatoo.kg.eventregistration.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EmailService emailService;

    public Participant registerParticipant(String email, Long eventId) {
        Participant participant = new Participant();
        participant.setEmail(email);
        participant.setConfirmationStatus(false);
        participant.setConfirmationToken(generateConfirmationToken());

        return participantRepository.save(participant);
    }

    private String generateConfirmationToken() {
        return UUID.randomUUID().toString();
    }
    public void confirmRegistration(String token) {
        Participant participant = participantRepository.findByConfirmationToken(token);
        if (participant != null) {
            participant.setConfirmationStatus(true);
            participant.setConfirmationToken(null);
            participantRepository.save(participant);
        }
    }
}
