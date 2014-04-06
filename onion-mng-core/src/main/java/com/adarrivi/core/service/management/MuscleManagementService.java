package com.adarrivi.core.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Muscle;

@Service
public class MuscleManagementService extends GenericManagementService<Muscle> {

    @Autowired
    public MuscleManagementService(@Qualifier("muscleDao") CrudDao<Muscle> crudDao) {
        super(crudDao);
    }

}
