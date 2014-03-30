package com.adarrivi.external.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.adarrivi.core.entity.RelativePosition;

@Entity
@Table(name = "Muscle")
public class MuscleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private RelativePosition relativePosition;

    @ManyToMany(cascade = { CascadeType.DETACH })
    @JoinTable(name = "MuscleAnchor", joinColumns = { @JoinColumn(name = "muscleId", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "anchorId", referencedColumnName = "id") })
    private List<AnchorEntity> anchors = new ArrayList<>();

    MuscleEntity() {
        // Needed by hibernate
    }

    @SuppressWarnings("unchecked")
    public MuscleEntity(String name, RelativePosition relativePosition, List<? extends AnchorEntity> anchors) {
        this.name = name;
        this.relativePosition = relativePosition;
        this.anchors = (List<AnchorEntity>) anchors;
    }

    public String getName() {
        return name;
    }

    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    public List<? extends AnchorEntity> getAnchors() {
        return anchors;
    }

}
