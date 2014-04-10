package com.adarrivi.relational.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarrivi.relational.entity.MuscleEntity;

public interface MuscleJpaRepository extends JpaRepository<MuscleEntity, Integer> {

}
