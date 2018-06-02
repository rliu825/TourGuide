package com.guide.tour;

import com.guide.tour.model.Customer;
import com.guide.tour.model.Guide;
import com.guide.tour.model.Tourist;
import com.guide.tour.repository.ContactRepository;
import com.guide.tour.repository.CustomerRepository;
import com.guide.tour.repository.GuideRepository;
import com.guide.tour.repository.TouristRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Application{
    private static final Logger log = LoggerFactory.getLogger(ContactRepository.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public CommandLineRunner initializeContact(ContactRepository repository) {
        return (args) -> {};
    }

    @Bean
    public CommandLineRunner initializeTourist(TouristRepository repository) {
        return (args) -> {
            repository.save(new Tourist("Boolean", "Chinese","7788981234","torres@ca.com"));
        };
    }

    @Bean
    public CommandLineRunner initializeGuide(GuideRepository repository) {
        return (args) -> {
            repository.save(new Guide("EddieGuide", "English","123456678","eddie@ca.com"));
        };
    }

    /*
    This is just a demo on how the JDA ORM works -- eg. findAll() findByFirstName
     */
    @Bean
    public CommandLineRunner anyName(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                .ifPresent(customer -> {
                    log.info("Customer found with findById(1L):");
                    log.info("--------------------------------");
                    log.info(customer.toString());
                    log.info("");
                });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}