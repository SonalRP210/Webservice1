package azure.loc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class , DataSourceAutoConfiguration.class})
public class LetterOfCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetterOfCreditApplication.class, args);
	}

}
