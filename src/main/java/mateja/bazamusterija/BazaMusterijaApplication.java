package mateja.bazamusterija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BazaMusterijaApplication {

	public static void main(String[] args) {
		Customers.LoadCustomerInformation();
		SpringApplication.run(BazaMusterijaApplication.class, args);
	}

}
