package com.adarrivi.external.jpa.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adarrivi.core.adapter.EntityAdapter;
import com.adarrivi.core.entity.Anchor;
import com.adarrivi.core.entity.Bone;
import com.adarrivi.core.entity.Fascia;
import com.adarrivi.external.jpa.entity.AnchorEntity;
import com.adarrivi.external.jpa.entity.BoneEntity;
import com.adarrivi.external.jpa.entity.FasciaEntity;

@Component("anchorEntityAdapter")
public class AnchorEntityAdapter implements EntityAdapter<Anchor, AnchorEntity> {

    @Autowired
    private BoneEntityAdapter boneEntityAdapter;
    @Autowired
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
