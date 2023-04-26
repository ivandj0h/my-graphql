package com.ivandjoh.demo.service;

import com.ivandjoh.demo.model.Country;
import com.ivandjoh.demo.repository.CountryRepository;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryService {

    private final HttpGraphQlClient graphQlClient;

    public CountryService(CountryRepository countryRepository) {

        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com/")
                .build();
        graphQlClient = HttpGraphQlClient.builder(client)
                .build();
    }

    public Mono<List<Country>> getAllCountries() {

        // language=GraphQL
        String document = """
                query {
                    countries {
                        name
                        emoji
                        currency
                        code
                        capital
                    }
                }
                """;

        return graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);
    }
}
