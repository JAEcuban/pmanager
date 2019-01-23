package jae.phones.JAEphones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JaEphonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaEphonesApplication.class, args);
	}

}

