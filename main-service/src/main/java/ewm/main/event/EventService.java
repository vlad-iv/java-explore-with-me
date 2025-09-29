package ewm.main.event;

import java.util.List;

public class EventService {
    public List<EventDto> findBy(PublicEventParam param) {
//		BooleanExpression byCategory = QEvent.event.category.eq(category);
        List<Event> events = repository.findBy();
        // 1, 2, 3...
        // /events/1 , /events/2 ...
		int views = statClient.getStat();

	}

	private BooleanExpression toExpresion(PublicEventParam param) {
		return null;
	}

	public void findBy(PrivateEventParam param) {

	}

	public void findBy(AdminEventParam param) {

	}
}
