package com.ivandjoh.demo;

import com.ivandjoh.demo.model.Country;
import com.ivandjoh.demo.repository.CountryRepository;
import com.ivandjoh.demo.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CountryService service, CountryRepository repository) {
		return args -> {
			Mono<List<Country>> countries = service.getAllCountries();
			countries.subscribe(repository::saveAll);
		};
	}
}
