package com.adarrivi.norelational.adapter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Anchor;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.core.entity.Muscle;
import com.adarrivi.norelational.entity.AnchorJson;
import com.adarrivi.norelational.entity.BoneJson;
import com.adarrivi.norelational.entity.FasciaJson;
import com.adarrivi.norelational.entity.MuscleJson;

@Component
public class MuscleJsonAdapter implements EntityAdapter<Muscle, MuscleJson> {

    @Autowired
    private BoneJsonAdapter boneJsonAdapter;
    @Autowired
    private FasciaJsonAdapter fasciaJsonAdapter;

    @Override
    public MuscleJson convertFrom(Muscle from) {
        Collection<AnchorJson> anchors = new ArrayList<>();
        for (Anchor anchor : from.getAnchors()) {
            if (anchor instanceof Fascia) {
                anchors.add(fasciaJsonAdapter.convertFrom((Fascia) anchor));
            } else {
                anchors.add(boneJsonAdapter.convertFrom((Bone) anchor));
            }
        }
        return new MuscleJson(from.getName(), from.getRelativePosition(), anchors);
    }

    @Override
    public Muscle convertTo(MuscleJson to) {
        Collection<Anchor> anchors = new ArrayList<>();
        for (AnchorJson anchor : to.getAnchors()) {
            if (anchor instanceof FasciaJson) {
                anchors.add(fasciaJsonAdapter.convertTo((FasciaJson) anchor));
            } else {
                anchors.add(boneJsonAdapter.convertTo((BoneJson) anchor));
            }
        }
        return new Muscle(to.getName(), to.getRelativePosition(), anchors);
    }
}
