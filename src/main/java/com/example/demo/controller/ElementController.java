package com.example.demo.controller;

import com.example.demo.service.Element;
import com.example.demo.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/element")
public class ElementController {

    private final ElementRequestToElementMapper elementRequestToElementMapper;
    private final ElementService elementService;

    @Autowired
    public ElementController(ElementService elementService, ElementRequestToElementMapper elementRequestToElementMapper) {
        this.elementService = elementService;
        this.elementRequestToElementMapper = elementRequestToElementMapper;
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public String transformElements(@RequestBody ElementRequest request) {
        Element element = elementRequestToElementMapper.elementRequestToElement(request);
        return elementService.transform(element);
    }
}
