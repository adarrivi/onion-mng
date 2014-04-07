package com.adarrivi.norelational.entity;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.adarrivi.core.entity.RelativePosition;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = BoneJson.class, name = "bone"), @Type(value = FasciaJson.class, name = "fascia") })
public abstract class AnchorJson {

    private String name;
    private RelativePosition relativePosition;

    protected AnchorJson() {
        // Constructor required for the json-pojo parser
    }

    protected AnchorJson(String name, RelativePosition relativePosition) {
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
