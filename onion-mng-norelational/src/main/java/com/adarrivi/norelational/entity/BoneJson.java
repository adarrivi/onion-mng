package com.adarrivi.norelational.entity;

import com.adarrivi.core.entity.RelativePosition;

public class BoneJson extends AnchorJson {

    BoneJson() {
        super();
        // Constructor required for the json-pojo parser
    }

    public BoneJson(String name, RelativePosition relativePosition) {
        super(name, relativePosition);
    }

}
