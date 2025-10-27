package ewm.main.event;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomEventRepository {
    List<Event> findBy(PublicEventParam param, Pageable pageable);
}
