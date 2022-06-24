package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<CountryEntity, Long> {
}
