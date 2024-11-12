package alatoo.kg.eventregistration.dtos;

import lombok.Data;

@Data
public class ParticipantRegistrationDTO {
    private String email;
    private Long eventId;
}
