package ewm.client;

import ewm.ParamHitDto;
import ewm.ParamStatDto;
import ewm.StatDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RestStatClient implements StatClient {
    final RestTemplate template;
    final String statUrl;

    public RestStatClient(RestTemplate template, @Value("${client.url}") String statUrl) {
        this.template = template;
        this.statUrl = statUrl;
    }


    @Override
    public void hit(ParamHitDto paramHitDto) {
//        template
        StatDto result = template.getForObject(statUrl, StatDto.class, paramHitDto);
        // 1. try catch обработать исключение + выбросить его же
        // 2. try catch обработать исключение + обернуть в свое
        // 3. try catch обработать исключение + заглушить
        // 4. Ничего не делаем, поймает обработчик ошибок
    }

    //
    @Override
    public List<StatDto> getStat(ParamStatDto paramDto) {
//        template
        return Collections.singletonList(new StatDto());
    }

    public static void main(String[] args) {

//		String uri = "kjkj kjkf 8#$#$#$^ 65^%#@#$%";
//		statClient.hit(Collections.singltonList(uri));
//
//		for (String uri : uris) {
//			uriBuilder.append("&uris=").append(uri);
//		}
//
//		String join = String.join(",", uris);
//
//		// stat/hit?uris=/events/1,/events/2,/events/3 - не работает
//		Sting uris;
//		// stat/hit?uris=/events/1&uris=/events/2&uris=/events/3 - работает
        List<String> uris = new ArrayList<>();
//		String url = "stat/hit?uris=" + uris; // Так не правильно
        // немного лучше
        String url = "stat/hit?"; // Так не правильно
        for (String uri : uris) {
            url = url + "&uris=" + uri;
        }
        // Лучше через Uri builder


//        GET /events/{eventId}
// 1. получили данные от репозитория
// 2. преобразовали в DTO + запросили из статистики просмотры

// 3. записали в статистику +1


//        GET /events

        // Основной сервис
//        GET /events/{eventId}
//     1. Обрабатываем запрос, загружаем данные по  мероприяютию
        // 2. Запрашиваем статистику - слой сервиса EventServiceImpl (требование)
        //3. Увеличиваем hit - слой контроллера EventController (рекомендация)

        // Основной сервис
//        GET /events
//     1. Обрабатываем запрос, загружаем данные по  мероприяютия (1, 44, 100 - ид событий)
        // 2. Запрашиваем статистику по мероприятиям (Массив из /events/{eventId}) - слой сервиса
        // /events/1 ,  /events/44, /events/100
        // Отправляется все в 1 запросе в статистку
        //3. Увеличиваем hit
        // /events/1 ,  /events/44, /events/100  - не верно!!!
        // только для /events - слой контроллера
    }
}
