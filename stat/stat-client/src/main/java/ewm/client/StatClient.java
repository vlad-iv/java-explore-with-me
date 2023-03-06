package ewm.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import ewm.ParamDto;
import ewm.ParamHitDto;
import ewm.StatDto;

@Component
public class StatClient {
    final RestClient restClient;
    final String statUrl;

    public StatClient(RestTemplate template, @Value("${client.url}") String statUrl) {
//        this.template = template;
        this.restClient = RestClient.builder()
                .baseUrl(statUrl)
                .build();
        this.statUrl = statUrl;
    }

    public void hit(ParamHitDto paramHitDto) {
        try {
            restClient.post()
                    .uri("/hit/{userId}");
            return restClient.get()
//                    .uri(UriComponentsBuilder.fromPath("/start")
//                            .queryParam("uris", params.getUris())
//                            .build())
//                    .uri("/stats?start={start}&uris={uris}", pathParams)
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("start", params.getStart())
                            .build()
                    )
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
public List<StatDto> getStat(ParamDto paramDto) {
//        template
    return Collections.emptyList();
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
