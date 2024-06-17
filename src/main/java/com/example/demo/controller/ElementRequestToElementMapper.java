package com.example.demo.controller;

import com.example.demo.service.Element;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ElementRequestToElementMapper {
    Element elementRequestToElement(ElementRequest elementRequest);
}
