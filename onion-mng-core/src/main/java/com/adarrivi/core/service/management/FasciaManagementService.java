package com.adarrivi.core.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Fascia;

@Service
public class FasciaManagementService extends GenericManagementService<Fascia> {

    @Autowired
    public FasciaManagementService(@Qualifier("fasciaDao") CrudDao<Fascia> fasciaDao) {
        super(fasciaDao);
    }

}
