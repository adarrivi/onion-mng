package com.adarrivi.external.jpa.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adarrivi.external.jpa.entity.BoneEntity;

public interface BoneJpaRepository extends JpaRepository<BoneEntity, Integer> {
    @Query("from BoneEntity where name=:name")
    BoneEntity findByName(@Param("name") String name);
}
