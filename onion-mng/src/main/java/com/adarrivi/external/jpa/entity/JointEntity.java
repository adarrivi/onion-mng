package com.adarrivi.external.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.adarrivi.core.entity.RelativePosition;

@Entity
@Table(name = "Joint")
public class JointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private RelativePosition relativePosition;

    @ManyToOne
    @JoinColumn(name = "bone1Id")
    private BoneEntity bone1;
    @ManyToOne
    @JoinColumn(name = "bone2Id")
    private BoneEntity bone2;

    JointEntity() {
        // Needed by hibernate
    }

    public JointEntity(String name, RelativePosition relativePosition, BoneEntity bone1, BoneEntity bone2) {
        this.name = name;
        this.relativePosition = relativePosition;
        this.bone1 = bone1;
        this.bone2 = bone2;
    }

    public String getName() {
        return name;
    }

    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    public BoneEntity getBone1() {
        return bone1;
    }

    public BoneEntity getBone2() {
        return bone2;
    }

}
