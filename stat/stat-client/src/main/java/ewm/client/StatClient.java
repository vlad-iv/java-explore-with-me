package ewm.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@Component
public class StatClient {
    final RestTemplate template;
    final String statUrl;

    public StatClient(RestTemplate template, @Value("${client.url}") String statUrl) {
        this.template = template;
        this.statUrl = statUrl;
    }

    //    public void hit(ParamHitDto paramHitDto) {
//        template
//    }
//
//    public StatDto getStat(ParamDto paramDto) {
//        template
//        return new StatDto();
//    }
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
//		// stat/hit?uris=1,2,3 - не работает
//		Sting uris;
//		// stat/hit?uris=1&uris=2&uris=3 - работает
        List<String> uris = new ArrayList<>();
//		String url = "stat/hit?uris=" + uris; // Так не правильно
        // немного лучше
        String url = "stat/hit?"; // Так не правильно
        for (String uri : uris) {
            url = url + "&uris=" + uri;
        }
        // Лучше через Uri builder


//        GET /events/{eventId}
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
