package ma.ens.client_service;

import ma.ens.client_service.entities.Client;
import ma.ens.client_service.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner initDatabase(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(null, "Abla", 23f));
            clientRepository.save(new Client(null, "Kaoutar", 23f));
            clientRepository.save(new Client(null, "Ikram", 19f));

        };
    }

}
