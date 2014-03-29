package com.adarrivi.core.service.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adarrivi.core.dao.CrudDao;
import com.adarrivi.core.entity.Bone;

@Service
public class BoneManagementService extends GenericManagementService<Bone> {

    @Autowired
    public BoneManagementService(@Qualifier("boneDao") CrudDao<Bone> crudDao) {
        super(crudDao);
    }

}
