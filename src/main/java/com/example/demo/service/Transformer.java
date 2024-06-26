package com.example.demo.service;

import java.util.List;

public class Transformer {

    private int transformerId;
    private int groupId;

    private List<String> parameters;

    public Transformer(){

    }

    public Transformer(int transformerId, int groupId, List<String> parameters) {
        this.transformerId = transformerId;
        this.groupId = groupId;
        this.parameters = parameters;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public int getTransformerId() {
        return transformerId;
    }

    public void setTransformerId(int transformerId) {
        this.transformerId = transformerId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
