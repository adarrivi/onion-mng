package com.adarrivi.norelational.entity;

import com.adarrivi.core.entity.RelativePosition;

public class FasciaJson extends AnchorJson {

    FasciaJson() {
        super();
        // Constructor required for the json-pojo parser
    }

    public FasciaJson(String name, RelativePosition relativePosition) {
        super(name, relativePosition);
    }

}
