package com.example.demo.controller;

import java.util.List;

public class ElementRequest {
    private String value;
    private List<TransformerRequest> transformers;

    public ElementRequest() {}

    public ElementRequest(String value, List<TransformerRequest> transformers) {
        this.value = value;
        this.transformers = transformers;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TransformerRequest> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<TransformerRequest> transformers) {
        this.transformers = transformers;
    }
}
