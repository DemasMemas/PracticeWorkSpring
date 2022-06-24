package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.OfficeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficeRepo extends CrudRepository<OfficeEntity, Long> {
    List<OfficeEntity> findAllByOrgIdAndNameIsLikeAndPhoneIsLike(Long orgId, String name, String Phone);
}
