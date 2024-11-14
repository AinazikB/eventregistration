package alatoo.kg.eventregistration.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(name = "confirmed", nullable = false)
    private Boolean confirmationStatus = false;

    private String confirmationToken;

    @ManyToMany
    @JoinTable(
            name = "participant_event",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> events = new HashSet<>();
    public Participant(String email, String confirmationToken) {
        this.email = email;
        this.confirmationStatus = false;
        this.confirmationToken = confirmationToken;
    }


}
