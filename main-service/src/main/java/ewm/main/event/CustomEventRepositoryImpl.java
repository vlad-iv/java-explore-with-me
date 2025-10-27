package ewm.main.event;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CustomEventRepositoryImpl implements CustomEventRepository {
    private final JPAQueryFactory queryFactory;

    public CustomEventRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Event> findByUserId(PublicEventParam param, Pageable pageable) {
        BooleanExpression byCategory = QEvent.event.category.eq(param.category());
        List<Event> list = queryFactory.selectFrom(QEvent.event)
                .where(byCategory)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return list;
    }
}
