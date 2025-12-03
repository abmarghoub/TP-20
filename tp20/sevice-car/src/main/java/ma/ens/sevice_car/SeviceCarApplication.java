package ma.ens.sevice_car;

import ma.ens.sevice_car.entities.Car;
import ma.ens.sevice_car.entities.Client;
import ma.ens.sevice_car.models.CarResponse;
import ma.ens.sevice_car.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class SeviceCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeviceCarApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    @Bean
    CommandLineRunner initDatabase(CarRepository repository, RestTemplate restTemplate) {
        return args -> {
            // Liste des voitures à créer avec leur clientId
            Object[][] cars = {
                    {"Toyota", "Corolla", "ABC-123", 1L},
                    {"BMW", "X5", "XYZ-555", 2L},
                    {"Mercedes", "C200", "CAR-789", 1L}
            };

            for (Object[] carData : cars) {
                String brand = (String) carData[0];
                String model = (String) carData[1];
                String matricule = (String) carData[2];
                Long clientId = (Long) carData[3];

                // Récupération du client depuis le service client
                String clientServiceUrl = "http://localhost:8888/client-service/api/client/" + clientId;
                Client client = null;
                try {
                    client = restTemplate.getForObject(clientServiceUrl, Client.class);
                } catch (Exception e) {
                    System.err.println("Erreur lors de la récupération du client " + clientId + ": " + e.getMessage());
                }

                if (client != null) {
                    Car car = new Car();
                    car.setBrand(brand);
                    car.setModel(model);
                    car.setMatricule(matricule);
                    car.setClient_id(client.getId());

                    repository.save(car);

                    System.out.println("Voiture créée avec le client: " + client.getNom() + " - " + car);
                } else {
                    System.out.println("Client avec ID " + clientId + " introuvable, voiture non créée.");
                }
            }
        };
    }

}
