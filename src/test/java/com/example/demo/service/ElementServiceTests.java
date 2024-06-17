package com.example.demo.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ElementServiceTests {

	@Autowired
	ElementService elementService;

	@Test
	void simpleTransformerTest_shouldReturn_MyNameIs() {
		List<Transformer> transformers = new ArrayList<>();
		List<String> parameters = new LinkedList<>();
		parameters.add("Veljko");
		transformers.add(new Transformer(1, 1, parameters));
		Element e = new Element("My name is Veljko", transformers);

		Pair<String, String> pair =  elementService.transform(e);

		assertEquals(new ImmutablePair<>("My name is Veljko", "My name is "), pair);
	}

	@Test
	void firstTransformerTest() {
		List<String> parameters = new LinkedList<>();
		parameters.add("Veljko and I am a");
		Transformer transformer = new Transformer(1, 1, parameters);
		String value = "Hello my name is Veljko and I am a Software Engineer";

		String result = elementService.firstTransformation(value, transformer);

		assertEquals("Hello my name is  Software Engineer", result);
	}

	@Test
	void secondTransformerTest() {
		List<String> parameters = new LinkedList<>();
		parameters.add("Veljko and I am a");
		parameters.add("Dragan -");
		Transformer transformer = new Transformer(2, 1, parameters);
		String value = "Hello my name is Veljko and I am a Software Engineer";

		String result = elementService.secondTransformation(value, transformer);

		assertEquals("Hello my name is Dragan - Software Engineer", result);
	}

	@Test
	void thirdTransformerTest() {
		Transformer transformer = new Transformer(3, 1, new LinkedList<>());
		String value = "Здраво, моје име је Вељко Ђошовић";

		String result = elementService.thirdTransformation(value, transformer);

		assertEquals("Zdravo, moje ime je Veljko Djosovic", result);
	}

}
