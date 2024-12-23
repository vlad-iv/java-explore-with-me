package ewm.main.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import main.client.StatClient;

@RestController
@AllArgsConstructor
public class PublicEventController {
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	final StatClient statClient;
	EventService eventService;

	@GetMapping
	List<EventDto> findBy(String name, String category, LocalDate start) {
		PublicEventParam param = new PublicEventParam(name, category, start);
		eventService.findBy(param);
		statClient.hit();
	}


}
