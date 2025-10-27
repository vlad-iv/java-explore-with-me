package ewm.main.event;

import com.querydsl.core.types.dsl.BooleanExpression;
import ewm.ParamStatDto;
import ewm.StatDto;
import ewm.client.StatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository repository;
    private final StatClient statClient;

    public List<EventDto> findBy(PublicEventParam param) {
//		BooleanExpression byCategory = QEvent.event.category.eq(category);
        List<Event> events = repository.findByCategory("");
//        repository.findAll(byCategory(param));

        // 1, 2, 3...
        // /events/1 , /events/2 ...
        List<StatDto> views = statClient.getStat(new ParamStatDto());
        return Collections.emptyList();

    }

    private BooleanExpression toExpresion(PublicEventParam param) {
        return null;
    }

    public void findBy(PrivateEventParam param) {
//        BooleanExpression byCategory = QEvent.event.category.eq(category);
//        List<Event> events = eventRepo.findAll(byCategory, pageRequest).toList();
    }

    public void findBy(AdminEventParam param) {

    }
}
