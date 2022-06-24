package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.OrganizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepo extends CrudRepository<OrganizationEntity, Long> {
    List<OrganizationEntity> findAllByNameIsLikeAndInnIsLike(String nameFilter, String innFilter);
    List<OrganizationEntity> findAllByNameIsLike(String nameFilter);
}
