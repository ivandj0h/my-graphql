package com.ivandjoh.demo.repository;

import com.ivandjoh.demo.model.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country, Integer> { }
