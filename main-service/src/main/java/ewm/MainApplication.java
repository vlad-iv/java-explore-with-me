package ewm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ewm.client.StatClient;

@SpringBootApplication
public class MainApplication {
	/// user-category-event-request-compilation

	// 1. user->
	// 2. category->
	// 3. event->
	// 4. request->
	// 5. compilation

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
		StatClient statClient = context.getBean(StatClient.class);
		statClient.hit(new ParamHitDto());
		statClient.getStat(new ParamStatDto());

	}
}
