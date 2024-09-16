package fiap.com.br.ursaChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan
@ComponentScan
@SpringBootApplication
public class UrsaChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrsaChallengeApplication.class, args);
	}

}
