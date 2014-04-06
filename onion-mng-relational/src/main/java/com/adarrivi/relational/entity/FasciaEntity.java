package com.adarrivi.relational.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.adarrivi.core.entity.RelativePosition;

@Entity
@Table(name = "Fascia")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class FasciaEntity extends AnchorEntity {

    public FasciaEntity() {
        super();
    }

    public FasciaEntity(String name, RelativePosition relativePosition) {
        super(name, relativePosition);
    }

}
