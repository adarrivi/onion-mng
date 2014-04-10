package com.adarrivi.relational.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adarrivi.relational.entity.JointEntity;

public interface JointJpaRepository extends JpaRepository<JointEntity, Integer> {

}
