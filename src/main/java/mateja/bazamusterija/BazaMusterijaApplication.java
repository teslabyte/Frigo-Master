package mateja.bazamusterija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = "mateja.bazamusterija")
@EnableMongoRepositories
public class BazaMusterijaApplication {

	public static void main(String[] args) {

		SpringApplication.run(BazaMusterijaApplication.class, args);
	}

}
