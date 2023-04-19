package com.ivandjoh.demo.service.Impl;

import com.ivandjoh.demo.model.Country;
import com.ivandjoh.demo.service.CountryService;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;

@Service
public class CountryServiceImpl implements CountryService {

    private final HttpGraphQlClient httpGraphQlClient;

    public CountryServiceImpl(HttpGraphQlClient httpGraphQlClient) {
        this.httpGraphQlClient = httpGraphQlClient;
    }

    public CountryServiceImpl() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com/")
                .build();
        httpGraphQlClient = HttpGraphQlClient.builder()
                .webClient((Consumer<WebClient.Builder>) client)
                .build();
    }

    @Override
    public Mono<List<Country>> getAllCountries() {
        return null;
    }
}
