package ewm.main.event;

import java.time.LocalDate;

public record PublicEventParam(String name, String category, LocalDate start) {
}
