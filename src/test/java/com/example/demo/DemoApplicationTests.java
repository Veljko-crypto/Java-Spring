package com.example.demo;

import com.example.demo.controller.ElementRequest;
import com.example.demo.controller.ElementRequestToElementMapper;
import com.example.demo.controller.TransformerRequest;
import com.example.demo.service.Element;
import com.example.demo.service.ElementService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	ElementService elementService;
	ElementRequestToElementMapper elementRequestToElementMapper;

//	@Test
	void firstTransformer() {
//		List<ElementRequest> requests = new LinkedList<>();
//		List<TransformerRequest> transformerRequests = new ArrayList<>();
//		List<String> params = new ArrayList<>();
//		params.add("John");
//		transformerRequests.add(new TransformerRequest(1, 1, params));
//		ElementRequest e1 = new ElementRequest("My name is John!", transformerRequests);
//		StringBuilder sb = new StringBuilder();
//
//		for(ElementRequest request : requests) {
//			Element element = elementRequestToElementMapper.elementRequestToElement(request);
//			sb.append(elementService.transform(element));
//		}
//
//		System.out.println("HELLO" + sb.toString());
//
//		assertTrue(sb.toString().equals("My name is !"));
	}

}
