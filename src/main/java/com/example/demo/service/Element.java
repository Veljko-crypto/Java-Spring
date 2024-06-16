package com.example.demo.service;

import java.util.List;

public class Element {

    private String value;
    private List<Transformer> transformers;

    public Element() {}

    public Element(String value, List<Transformer> transformers) {
        this.value = value;
        this.transformers = transformers;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Transformer> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<Transformer> transformers) {
        this.transformers = transformers;
    }
}
