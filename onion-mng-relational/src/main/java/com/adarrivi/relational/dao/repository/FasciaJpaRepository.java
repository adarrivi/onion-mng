package com.adarrivi.relational.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adarrivi.relational.entity.FasciaEntity;

public interface FasciaJpaRepository extends JpaRepository<FasciaEntity, Integer> {
    @Query("from FasciaEntity where name=:name")
    FasciaEntity findByName(@Param("name") String name);
}
