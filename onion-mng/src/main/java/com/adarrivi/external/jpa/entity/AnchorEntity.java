package com.adarrivi.external.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.adarrivi.core.entity.RelativePosition;

@Entity
@Table(name = "Anchor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AnchorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private RelativePosition relativePosition;

    AnchorEntity() {
        // Needed by hibernate
    }

    public AnchorEntity(String name, RelativePosition relativePosition) {
        this.name = name;
        this.relativePosition = relativePosition;
    }

    public String getName() {
        return name;
    }

    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

}
