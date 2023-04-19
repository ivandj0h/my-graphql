package com.ivandjoh.demo.service;

import com.ivandjoh.demo.model.Country;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CountryService {
    Mono<List<Country>> getAllCountries();
}
