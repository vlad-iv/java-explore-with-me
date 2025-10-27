package ewm.main.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    Long id;

    String name;
    String category;
}
