package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.DocEntity;
import org.springframework.data.repository.CrudRepository;

public interface DocRepo extends CrudRepository<DocEntity, Long> {
}
