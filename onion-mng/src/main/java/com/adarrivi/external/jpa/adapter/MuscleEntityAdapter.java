package com.adarrivi.external.jpa.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Anchor;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.external.jpa.dao.repository.BoneJpaRepository;
import com.adarrivi.external.jpa.dao.repository.FasciaJpaRepository;
import com.adarrivi.external.jpa.entity.AnchorEntity;
import com.adarrivi.external.jpa.entity.MuscleEntity;

@Component("muscleEntityAdapter")
public class MuscleEntityAdapter implements EntityAdapter<Muscle, MuscleEntity> {

    @Autowired
    private AnchorEntityAdapter anchorEntityAdapter;
    @Autowired
    private FasciaJpaRepository fasciaJpaRepository;
    @Autowired
    private BoneJpaRepository boneJpaRepository;

    @Override
    public MuscleEntity convertFrom(Muscle from) {
        List<AnchorEntity> anchorEntities = new ArrayList<>();
        for (Anchor anchor : from.getAnchors()) {
            if (anchor instanceof Bone) {
                anchorEntities.add(boneJpaRepository.findByName(anchor.getName()));
            } else {
                anchorEntities.add(fasciaJpaRepository.findByName(anchor.getName()));
            }
        }
        return new MuscleEntity(from.getName(), from.getRelativePosition(), anchorEntities);
    }

    @Override
    public Muscle convertTo(MuscleEntity to) {
        List<Anchor> anchors = new ArrayList<>();
        for (AnchorEntity anchorEntity : to.getAnchors()) {
            anchors.add(anchorEntityAdapter.convertTo(anchorEntity));
        }
        return new Muscle(to.getName(), to.getRelativePosition(), anchors);
    }

}
