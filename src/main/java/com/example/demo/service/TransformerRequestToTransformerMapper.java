package com.example.demo.service;

import com.example.demo.controller.TransformerRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransformerRequestToTransformerMapper {
    Transformer transformerRequestToTransformerMapper(TransformerRequest transformerRequest);
}
