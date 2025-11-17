package ewm.main.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    Long id;

    String name;
    String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Nullable
    private LocalDateTime eventDate;
}
