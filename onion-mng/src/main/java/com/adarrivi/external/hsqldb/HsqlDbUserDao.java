package com.adarrivi.external.hsqldb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HsqlDbUserDao extends JpaRepository<HsqlDbUserEntity, Integer> {

}
