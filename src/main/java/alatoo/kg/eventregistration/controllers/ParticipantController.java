package alatoo.kg.eventregistration.controllers;

import alatoo.kg.eventregistration.dtos.ParticipantRegistrationDTO;
import alatoo.kg.eventregistration.entities.Participant;
import alatoo.kg.eventregistration.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping("/register")
    public ResponseEntity<Participant> registerParticipant(
            @RequestBody ParticipantRegistrationDTO registrationDTO) {
        Participant participant = participantService.registerParticipant(registrationDTO.getEmail(), registrationDTO.getEventId());
        return ResponseEntity.ok(participant);
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirmRegistration(@RequestParam String token) {
        participantService.confirmRegistration(token);
        return ResponseEntity.ok("Registration confirmed successfully!");
    }
}
