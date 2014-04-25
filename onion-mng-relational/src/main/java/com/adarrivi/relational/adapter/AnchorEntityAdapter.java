package com.adarrivi.relational.adapter;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Anchor;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.relational.entity.AnchorEntity;
import com.adarrivi.relational.entity.BoneEntity;
import com.adarrivi.relational.entity.FasciaEntity;

@Component
public class AnchorEntityAdapter implements EntityAdapter<Anchor, AnchorEntity> {

    @Inject
    private BoneEntityAdapter boneEntityAdapter;
    @Inject
    private FasciaEntityAdapter fasciaEntityAdapter;

    @Override
    public AnchorEntity convertFrom(Anchor from) {
        if (from instanceof Bone) {
            return boneEntityAdapter.convertFrom((Bone) from);
        }
        return fasciaEntityAdapter.convertFrom((Fascia) from);
    }

    @Override
    public Anchor convertTo(AnchorEntity to) {
        if (to instanceof BoneEntity) {
            return boneEntityAdapter.convertTo((BoneEntity) to);
        }
        return fasciaEntityAdapter.convertTo((FasciaEntity) to);
    }

}
