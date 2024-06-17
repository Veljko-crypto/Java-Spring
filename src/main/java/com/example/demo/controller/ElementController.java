package com.example.demo.controller;

import com.example.demo.service.Element;
import com.example.demo.service.ElementService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

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
    @ResponseStatus( HttpStatus.OK )
    public List<Pair<String, String>> transformElements(@RequestBody List<ElementRequest> requests) {
        List<Pair<String, String>> result = new LinkedList<>();
        requests.stream().forEach(request -> {
            Element element = elementRequestToElementMapper.elementRequestToElement(request);
            result.add(elementService.transform(element));
        });

        return result;
    }
}
