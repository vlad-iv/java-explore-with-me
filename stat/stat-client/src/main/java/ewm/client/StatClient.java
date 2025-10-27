package ewm.client;

import ewm.ParamHitDto;
import ewm.ParamStatDto;
import ewm.StatDto;

import java.util.List;

public interface StatClient {
    void hit(ParamHitDto paramHitDto);

    //
    List<StatDto> getStat(ParamStatDto paramDto);
}
