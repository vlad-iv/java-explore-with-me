package ewm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ewm.client.StatClient;

@SpringBootApplication
//@ComponentScan(value = {"ewm", "client"})
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);

        StatClient statClient = context.getBean(StatClient.class);
        statClient.hit(new ParamHitDto("/event/1")); // 1
        StatDto stat = statClient.getStat(new ParamDto("/event/1")); // 2
        System.out.println(stat); // 3 :  0, 1, -1, null

    }

//	@Bean
//	public StatClient statClient() {
//		return new RestStatClient();
//	}
}
