package ewm.main.event;

import ewm.ParamHitDto;
import ewm.client.StatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublicEventController {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    final StatClient statClient;
    final EventService eventService;

    @GetMapping
    List<EventDto> findBy(String name, String category, LocalDate start) {
        PublicEventParam param = new PublicEventParam(name, category, start);
        eventService.findBy(param);
        statClient.hit(new ParamHitDto());
        return Collections.emptyList();
    }


}
