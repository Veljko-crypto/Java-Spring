package com.example.demo.controller;

import java.util.List;

public class TransformerRequest {
    private int transformerId;
    private String groupId;

    private List<String> parameters;

    public TransformerRequest(){

    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public TransformerRequest(int transformerId, String groupId, List<String> parameters) {
        this.transformerId = transformerId;
        this.groupId = groupId;
        this.parameters = parameters;
    }

    public int getTransformerId() {
        return transformerId;
    }

    public void setTransformerId(int transformerId) {
        this.transformerId = transformerId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
