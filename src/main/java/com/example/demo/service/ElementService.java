package com.example.demo.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElementService {

    private static final String FIRST_TRANSFORMER_EXCEPTION_MESSAGE = "First transformer must have only one parameter";
    private static final String SECOND_TRANSFORMER_EXCEPTION_MESSAGE = "Second transformer must have only two parameters";
    private static final String THIRD_TRANSFORMER_EXCEPTION_MESSAGE = "Third transformer must have no parameters";
    private static final Map<Character, String> CYRILLIC_TO_LATIN_MAP = new HashMap<>();
    private static final Map<Character, String> GREEK_TO_LATIN_MAP = new HashMap<>();

    static {
        // Cyrillic to Latin mappings
        CYRILLIC_TO_LATIN_MAP.put('А', "A");
        CYRILLIC_TO_LATIN_MAP.put('Б', "B");
        CYRILLIC_TO_LATIN_MAP.put('В', "V");
        CYRILLIC_TO_LATIN_MAP.put('Г', "G");
        CYRILLIC_TO_LATIN_MAP.put('Д', "D");
        CYRILLIC_TO_LATIN_MAP.put('Ђ', "Dj");
        CYRILLIC_TO_LATIN_MAP.put('Е', "E");
        CYRILLIC_TO_LATIN_MAP.put('Ж', "Z");
        CYRILLIC_TO_LATIN_MAP.put('З', "Z");
        CYRILLIC_TO_LATIN_MAP.put('И', "I");
        CYRILLIC_TO_LATIN_MAP.put('Ј', "J");
        CYRILLIC_TO_LATIN_MAP.put('К', "K");
        CYRILLIC_TO_LATIN_MAP.put('Л', "L");
        CYRILLIC_TO_LATIN_MAP.put('Љ', "Lj");
        CYRILLIC_TO_LATIN_MAP.put('М', "M");
        CYRILLIC_TO_LATIN_MAP.put('Н', "N");
        CYRILLIC_TO_LATIN_MAP.put('Њ', "Nj");
        CYRILLIC_TO_LATIN_MAP.put('О', "O");
        CYRILLIC_TO_LATIN_MAP.put('П', "P");
        CYRILLIC_TO_LATIN_MAP.put('Р', "R");
        CYRILLIC_TO_LATIN_MAP.put('С', "S");
        CYRILLIC_TO_LATIN_MAP.put('Т', "T");
        CYRILLIC_TO_LATIN_MAP.put('Ћ', "C");
        CYRILLIC_TO_LATIN_MAP.put('У', "U");
        CYRILLIC_TO_LATIN_MAP.put('Ф', "F");
        CYRILLIC_TO_LATIN_MAP.put('Х', "H");
        CYRILLIC_TO_LATIN_MAP.put('Ц', "C");
        CYRILLIC_TO_LATIN_MAP.put('Ч', "C");
        CYRILLIC_TO_LATIN_MAP.put('Џ', "Dz");
        CYRILLIC_TO_LATIN_MAP.put('Ш', "S");

        CYRILLIC_TO_LATIN_MAP.put('а', "a");
        CYRILLIC_TO_LATIN_MAP.put('б', "b");
        CYRILLIC_TO_LATIN_MAP.put('в', "v");
        CYRILLIC_TO_LATIN_MAP.put('г', "g");
        CYRILLIC_TO_LATIN_MAP.put('д', "d");
        CYRILLIC_TO_LATIN_MAP.put('ђ', "dj");
        CYRILLIC_TO_LATIN_MAP.put('е', "e");
        CYRILLIC_TO_LATIN_MAP.put('ж', "z");
        CYRILLIC_TO_LATIN_MAP.put('з', "z");
        CYRILLIC_TO_LATIN_MAP.put('и', "i");
        CYRILLIC_TO_LATIN_MAP.put('ј', "j");
        CYRILLIC_TO_LATIN_MAP.put('к', "k");
        CYRILLIC_TO_LATIN_MAP.put('л', "l");
        CYRILLIC_TO_LATIN_MAP.put('љ', "lj");
        CYRILLIC_TO_LATIN_MAP.put('м', "m");
        CYRILLIC_TO_LATIN_MAP.put('н', "n");
        CYRILLIC_TO_LATIN_MAP.put('њ', "nj");
        CYRILLIC_TO_LATIN_MAP.put('о', "o");
        CYRILLIC_TO_LATIN_MAP.put('п', "p");
        CYRILLIC_TO_LATIN_MAP.put('р', "r");
        CYRILLIC_TO_LATIN_MAP.put('с', "s");
        CYRILLIC_TO_LATIN_MAP.put('т', "t");
        CYRILLIC_TO_LATIN_MAP.put('ћ', "c");
        CYRILLIC_TO_LATIN_MAP.put('у', "u");
        CYRILLIC_TO_LATIN_MAP.put('ф', "f");
        CYRILLIC_TO_LATIN_MAP.put('х', "h");
        CYRILLIC_TO_LATIN_MAP.put('ц', "c");
        CYRILLIC_TO_LATIN_MAP.put('ч', "c");
        CYRILLIC_TO_LATIN_MAP.put('џ', "dz");
        CYRILLIC_TO_LATIN_MAP.put('ш', "s");

        // Greek to Latin mappings
        GREEK_TO_LATIN_MAP.put('Α', "A");
        GREEK_TO_LATIN_MAP.put('Β', "B");
        GREEK_TO_LATIN_MAP.put('Γ', "G");
        GREEK_TO_LATIN_MAP.put('Δ', "D");
        GREEK_TO_LATIN_MAP.put('Ε', "E");
        GREEK_TO_LATIN_MAP.put('Ζ', "Z");
        GREEK_TO_LATIN_MAP.put('Η', "E");
        GREEK_TO_LATIN_MAP.put('Θ', "Th");
        GREEK_TO_LATIN_MAP.put('Ι', "I");
        GREEK_TO_LATIN_MAP.put('Κ', "K");
        GREEK_TO_LATIN_MAP.put('Λ', "L");
        GREEK_TO_LATIN_MAP.put('Μ', "M");
        GREEK_TO_LATIN_MAP.put('Ν', "N");
        GREEK_TO_LATIN_MAP.put('Ξ', "X");
        GREEK_TO_LATIN_MAP.put('Ο', "O");
        GREEK_TO_LATIN_MAP.put('Π', "P");
        GREEK_TO_LATIN_MAP.put('Ρ', "R");
        GREEK_TO_LATIN_MAP.put('Σ', "S");
        GREEK_TO_LATIN_MAP.put('Τ', "T");
        GREEK_TO_LATIN_MAP.put('Υ', "Y");
        GREEK_TO_LATIN_MAP.put('Φ', "Ph");
        GREEK_TO_LATIN_MAP.put('Χ', "Ch");
        GREEK_TO_LATIN_MAP.put('Ψ', "Ps");
        GREEK_TO_LATIN_MAP.put('Ω', "O");

        GREEK_TO_LATIN_MAP.put('α', "a");
        GREEK_TO_LATIN_MAP.put('β', "b");
        GREEK_TO_LATIN_MAP.put('γ', "g");
        GREEK_TO_LATIN_MAP.put('δ', "d");
        GREEK_TO_LATIN_MAP.put('ε', "e");
        GREEK_TO_LATIN_MAP.put('ζ', "z");
        GREEK_TO_LATIN_MAP.put('η', "e");
        GREEK_TO_LATIN_MAP.put('θ', "th");
        GREEK_TO_LATIN_MAP.put('ι', "i");
        GREEK_TO_LATIN_MAP.put('κ', "k");
        GREEK_TO_LATIN_MAP.put('λ', "l");
        GREEK_TO_LATIN_MAP.put('μ', "m");
        GREEK_TO_LATIN_MAP.put('ν', "n");
        GREEK_TO_LATIN_MAP.put('ξ', "x");
        GREEK_TO_LATIN_MAP.put('ο', "o");
        GREEK_TO_LATIN_MAP.put('π', "p");
        GREEK_TO_LATIN_MAP.put('ρ', "r");
        GREEK_TO_LATIN_MAP.put('σ', "s");
        GREEK_TO_LATIN_MAP.put('τ', "t");
        GREEK_TO_LATIN_MAP.put('υ', "y");
        GREEK_TO_LATIN_MAP.put('φ', "ph");
        GREEK_TO_LATIN_MAP.put('χ', "ch");
        GREEK_TO_LATIN_MAP.put('ψ', "ps");
        GREEK_TO_LATIN_MAP.put('ω', "o");

        GREEK_TO_LATIN_MAP.put('Ά', "A");
        GREEK_TO_LATIN_MAP.put('Έ', "E");
        GREEK_TO_LATIN_MAP.put('Ḗ', "H");
        GREEK_TO_LATIN_MAP.put('Í', "I");
        GREEK_TO_LATIN_MAP.put('Ó', "O");
        GREEK_TO_LATIN_MAP.put('Ύ', "Y");
        GREEK_TO_LATIN_MAP.put('Ώ', "O");

        GREEK_TO_LATIN_MAP.put('Á', "A");
        GREEK_TO_LATIN_MAP.put('É', "E");
        GREEK_TO_LATIN_MAP.put('Ή', "E");
        GREEK_TO_LATIN_MAP.put('Ί', "I");
        GREEK_TO_LATIN_MAP.put('Ό', "O");
        GREEK_TO_LATIN_MAP.put('Ý', "Y");
        GREEK_TO_LATIN_MAP.put('Ṓ', "O");

        GREEK_TO_LATIN_MAP.put('ά', "a");
        GREEK_TO_LATIN_MAP.put('έ', "e");
        GREEK_TO_LATIN_MAP.put('ή', "e");
        GREEK_TO_LATIN_MAP.put('ί', "i");
        GREEK_TO_LATIN_MAP.put('ό', "i");
        GREEK_TO_LATIN_MAP.put('ύ', "y");
        GREEK_TO_LATIN_MAP.put('ώ', "o");

        GREEK_TO_LATIN_MAP.put('á', "a");
        GREEK_TO_LATIN_MAP.put('é', "e");
        GREEK_TO_LATIN_MAP.put('ḗ', "e");
        GREEK_TO_LATIN_MAP.put('í', "i");
        GREEK_TO_LATIN_MAP.put('ó', "o");
        GREEK_TO_LATIN_MAP.put('ý', "y");
        GREEK_TO_LATIN_MAP.put('ṓ', "o");


    }

    public Pair<String, String> transform(Element element) {
        Map<Integer, List<Transformer>> groupMap = initializeTransformerMap(element);

        return new ImmutablePair<>(element.getValue(), transformElement(element, groupMap));
    }

    private String transformElement(Element element, Map<Integer, List<Transformer>> groupMap) {
        groupMap.keySet().stream().forEach(groupId ->
                groupMap.get(groupId).stream().forEach(t -> applyTransformers(element, t)));
        return element.getValue();
    }

    private void applyTransformers(Element element, Transformer t) {
        if(t.getTransformerId() == 1) {
            element.setValue(firstTransformation(element.getValue(), t));
        } else if(t.getTransformerId() == 2) {
            element.setValue(secondTransformation(element.getValue(), t));
        } else if(t.getTransformerId() == 3) {
            element.setValue(thirdTransformation(element.getValue(), t));
        }
    }

    private static Map<Integer, List<Transformer>> initializeTransformerMap(Element element) {
        Map<Integer, List<Transformer>> groupMap = new HashMap<>();
        element.getTransformers().stream().forEach(t -> addToGroupMap(groupMap, t));
        return groupMap;
    }

    private static void addToGroupMap(Map<Integer, List<Transformer>> groupMap, Transformer t) {
        if(!groupMap.containsKey(t.getGroupId())) {
            groupMap.put(t.getGroupId(), new LinkedList<>());
        }
        List<Transformer> temp = groupMap.get(t.getGroupId());
        temp.add(t);
        groupMap.put(t.getGroupId(), temp);
    }

    String firstTransformation(String value, Transformer t) {
        if(t.getParameters().size() != 1) {
            throw new IllegalStateException(FIRST_TRANSFORMER_EXCEPTION_MESSAGE);
        }
        String regex = t.getParameters().get(0);
        return value.replaceAll(regex, "");
    }

    String secondTransformation(String value, Transformer t) {
        if(t.getParameters().size() != 2) {
            throw new IllegalStateException(SECOND_TRANSFORMER_EXCEPTION_MESSAGE);
        }
        String regex = t.getParameters().get(0);
        String replacement = t.getParameters().get(1);
        return value.replaceAll(regex, replacement);
    }

    String thirdTransformation(String value, Transformer t) {
        if(!t.getParameters().isEmpty()) {
            throw new IllegalStateException(THIRD_TRANSFORMER_EXCEPTION_MESSAGE);
        }

        StringBuilder sb = new StringBuilder();

        for (char character : value.toCharArray()) {
            if (CYRILLIC_TO_LATIN_MAP.containsKey(character)) {
                sb.append(CYRILLIC_TO_LATIN_MAP.get(character));
            } else if (GREEK_TO_LATIN_MAP.containsKey(character)) {
                sb.append(GREEK_TO_LATIN_MAP.get(character));
            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }
}
