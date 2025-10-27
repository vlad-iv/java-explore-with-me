package ewm.main.controller.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserParam {
    String param1;
    String param2;
    String param3;
    String param4;
    String param5;
    String param6;
    Pageable pageable;

    boolean isParam1() {
        return param1 != null;
    }

    // Не рекомендуется
    String getSql() {
        UserParam userParam = new UserParam();
        StringBuilder sql = new StringBuilder();
        if (userParam.isParam1()) {
            sql.append("and param1 = :param1");
        }
        return sql.toString();
    }
}
