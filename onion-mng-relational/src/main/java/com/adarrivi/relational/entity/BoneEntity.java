package com.adarrivi.relational.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.adarrivi.core.entity.RelativePosition;

@Entity
@Table(name = "Bone")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class BoneEntity extends AnchorEntity {

    public BoneEntity() {
        super();
    }

    public BoneEntity(String name, RelativePosition relativePosition) {
        super(name, relativePosition);
    }

}
