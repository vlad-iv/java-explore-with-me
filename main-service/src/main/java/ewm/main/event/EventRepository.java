package ewm.main.event;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event>,
        CustomEventRepository {
    @EntityGraph(value = "event-with-category")
    List<Event> findByCategory(String category);

//    interface Specs {
//        static Specification<Event> byCategory(String category) {
//            return (root, query, builder) -> builder.equal(root.get(Event_.category), category);
//        }
//    }
}
