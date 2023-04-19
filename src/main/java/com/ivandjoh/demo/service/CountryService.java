package com.ivandjoh.demo.service;

import com.ivandjoh.demo.model.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;

@Service
public class CountryService {

    private final HttpGraphQlClient graphQlClient;

    public CountryService() {
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

        Mono<List<Country>> countries = graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);

        return countries;
    }
}
