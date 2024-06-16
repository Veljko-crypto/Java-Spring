package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElementService {

    private static final Map<Character, String> cyrillicToLatinMap = new HashMap<>();
    private static final Map<Character, String> greekToLatinMap = new HashMap<>();

    static {
        // Cyrillic to Latin mappings
        cyrillicToLatinMap.put('А', "A");
        cyrillicToLatinMap.put('Б', "B");
        cyrillicToLatinMap.put('В', "V");
        cyrillicToLatinMap.put('Г', "G");
        cyrillicToLatinMap.put('Д', "D");
        cyrillicToLatinMap.put('Ђ', "Dj");
        cyrillicToLatinMap.put('Е', "E");
        cyrillicToLatinMap.put('Ж', "Z");
        cyrillicToLatinMap.put('З', "Z");
        cyrillicToLatinMap.put('И', "I");
        cyrillicToLatinMap.put('Ј', "J");
        cyrillicToLatinMap.put('К', "K");
        cyrillicToLatinMap.put('Л', "L");
        cyrillicToLatinMap.put('Љ', "Lj");
        cyrillicToLatinMap.put('М', "M");
        cyrillicToLatinMap.put('Н', "N");
        cyrillicToLatinMap.put('Њ', "Nj");
        cyrillicToLatinMap.put('О', "O");
        cyrillicToLatinMap.put('П', "P");
        cyrillicToLatinMap.put('Р', "R");
        cyrillicToLatinMap.put('С', "S");
        cyrillicToLatinMap.put('Т', "T");
        cyrillicToLatinMap.put('Ћ', "C");
        cyrillicToLatinMap.put('У', "U");
        cyrillicToLatinMap.put('Ф', "F");
        cyrillicToLatinMap.put('Х', "H");
        cyrillicToLatinMap.put('Ц', "C");
        cyrillicToLatinMap.put('Ч', "C");
        cyrillicToLatinMap.put('Џ', "Dz");
        cyrillicToLatinMap.put('Ш', "S");

        cyrillicToLatinMap.put('а', "a");
        cyrillicToLatinMap.put('б', "b");
        cyrillicToLatinMap.put('в', "v");
        cyrillicToLatinMap.put('г', "g");
        cyrillicToLatinMap.put('д', "d");
        cyrillicToLatinMap.put('ђ', "dj");
        cyrillicToLatinMap.put('е', "e");
        cyrillicToLatinMap.put('ж', "z");
        cyrillicToLatinMap.put('з', "z");
        cyrillicToLatinMap.put('и', "i");
        cyrillicToLatinMap.put('ј', "j");
        cyrillicToLatinMap.put('к', "k");
        cyrillicToLatinMap.put('л', "l");
        cyrillicToLatinMap.put('љ', "lj");
        cyrillicToLatinMap.put('м', "m");
        cyrillicToLatinMap.put('н', "n");
        cyrillicToLatinMap.put('њ', "nj");
        cyrillicToLatinMap.put('о', "o");
        cyrillicToLatinMap.put('п', "p");
        cyrillicToLatinMap.put('р', "r");
        cyrillicToLatinMap.put('с', "s");
        cyrillicToLatinMap.put('т', "t");
        cyrillicToLatinMap.put('ћ', "c");
        cyrillicToLatinMap.put('у', "u");
        cyrillicToLatinMap.put('ф', "f");
        cyrillicToLatinMap.put('х', "h");
        cyrillicToLatinMap.put('ц', "c");
        cyrillicToLatinMap.put('ч', "c");
        cyrillicToLatinMap.put('џ', "dz");
        cyrillicToLatinMap.put('ш', "s");

        // Greek to Latin mappings
        greekToLatinMap.put('Α', "A");
        greekToLatinMap.put('Β', "B");
        greekToLatinMap.put('Γ', "G");
        greekToLatinMap.put('Δ', "D");
        greekToLatinMap.put('Ε', "E");
        greekToLatinMap.put('Ζ', "Z");
        greekToLatinMap.put('Η', "E");
        greekToLatinMap.put('Θ', "Th");
        greekToLatinMap.put('Ι', "I");
        greekToLatinMap.put('Κ', "K");
        greekToLatinMap.put('Λ', "L");
        greekToLatinMap.put('Μ', "M");
        greekToLatinMap.put('Ν', "N");
        greekToLatinMap.put('Ξ', "X");
        greekToLatinMap.put('Ο', "O");
        greekToLatinMap.put('Π', "P");
        greekToLatinMap.put('Ρ', "R");
        greekToLatinMap.put('Σ', "S");
        greekToLatinMap.put('Τ', "T");
        greekToLatinMap.put('Υ', "Y");
        greekToLatinMap.put('Φ', "Ph");
        greekToLatinMap.put('Χ', "Ch");
        greekToLatinMap.put('Ψ', "Ps");
        greekToLatinMap.put('Ω', "O");

        greekToLatinMap.put('α', "a");
        greekToLatinMap.put('β', "b");
        greekToLatinMap.put('γ', "g");
        greekToLatinMap.put('δ', "d");
        greekToLatinMap.put('ε', "e");
        greekToLatinMap.put('ζ', "z");
        greekToLatinMap.put('η', "e");
        greekToLatinMap.put('θ', "th");
        greekToLatinMap.put('ι', "i");
        greekToLatinMap.put('κ', "k");
        greekToLatinMap.put('λ', "l");
        greekToLatinMap.put('μ', "m");
        greekToLatinMap.put('ν', "n");
        greekToLatinMap.put('ξ', "x");
        greekToLatinMap.put('ο', "o");
        greekToLatinMap.put('π', "p");
        greekToLatinMap.put('ρ', "r");
        greekToLatinMap.put('σ', "s");
        greekToLatinMap.put('τ', "t");
        greekToLatinMap.put('υ', "y");
        greekToLatinMap.put('φ', "ph");
        greekToLatinMap.put('χ', "ch");
        greekToLatinMap.put('ψ', "ps");
        greekToLatinMap.put('ω', "o");

        greekToLatinMap.put('Ά', "A");
        greekToLatinMap.put('Έ', "E");
        greekToLatinMap.put('Ḗ', "H");
        greekToLatinMap.put('Í', "I");
        greekToLatinMap.put('Ó', "O");
        greekToLatinMap.put('Ύ', "Y");
        greekToLatinMap.put('Ώ', "O");

        greekToLatinMap.put('Á', "A");
        greekToLatinMap.put('É', "E");
        greekToLatinMap.put('Ή', "E");
        greekToLatinMap.put('Ί', "I");
        greekToLatinMap.put('Ό', "O");
        greekToLatinMap.put('Ý', "Y");
        greekToLatinMap.put('Ṓ', "O");

        greekToLatinMap.put('ά', "a");
        greekToLatinMap.put('έ', "e");
        greekToLatinMap.put('ή', "e");
        greekToLatinMap.put('ί', "i");
        greekToLatinMap.put('ό', "i");
        greekToLatinMap.put('ύ', "y");
        greekToLatinMap.put('ώ', "o");

        greekToLatinMap.put('á', "a");
        greekToLatinMap.put('é', "e");
        greekToLatinMap.put('ḗ', "e");
        greekToLatinMap.put('í', "i");
        greekToLatinMap.put('ó', "o");
        greekToLatinMap.put('ý', "y");
        greekToLatinMap.put('ṓ', "o");


    }

    public String transform(Element element) {
        Map<Integer, List<Transformer>> groupMap = new HashMap<>();
        element.getTransformers().stream().forEach(t -> {
            if(!groupMap.containsKey(t.getGroupId())) {
                groupMap.put(t.getGroupId(), new LinkedList<>());
            }
            List<Transformer> temp = groupMap.get(t.getGroupId());
            temp.add(t);
            groupMap.put(t.getGroupId(), temp);
        });

        StringBuilder sb = new StringBuilder();
        sb.append("Original value: ");
        sb.append(element.getValue());
        sb.append(" | Transformed value: ");
        groupMap.keySet().stream().forEach(groupId -> {
            groupMap.get(groupId).stream().forEach(t -> {
                if(t.getTransformerId() == 1) {
                    // 1st transformer
                    element.setValue(firstTransformation(element.getValue(), t, sb));
                } else if(t.getTransformerId() == 2) {
                    // 2nd transformer
                    element.setValue(secondTransformation(element.getValue(), t, sb));
                } else if(t.getTransformerId() == 3) {
                    // 3rd transformer
                    element.setValue(thirdTransformation(element.getValue(), t, sb));
                }
                sb.append(" | ");
            });
        });
        return element.getValue();
    }

    private String firstTransformation(String value, Transformer t, StringBuilder result) {
        if(t.getParameters().size() != 1) {
            throw new IllegalStateException("First transformer must have only one parameter");
        }
        String regex = t.getParameters().get(0);
        result.append(value.replaceAll(regex, ""));
        return result.toString();
    }

    private String secondTransformation(String value, Transformer t, StringBuilder result) {
        if(t.getParameters().size() != 2) {
            throw new IllegalStateException("Second transformer must have only two parameters");
        }
        String regex = t.getParameters().get(0);
        String replacement = t.getParameters().get(1);
        result.append(value.replaceAll(regex, replacement));
        return result.toString();
    }

    private String thirdTransformation(String value, Transformer t, StringBuilder result) {
        if(!t.getParameters().isEmpty()) {
            throw new IllegalStateException("Third transformer must have no parameters");
        }

        for (char character : value.toCharArray()) {
            if (cyrillicToLatinMap.containsKey(character)) {
                result.append(cyrillicToLatinMap.get(character));
            } else if (greekToLatinMap.containsKey(character)) {
                result.append(greekToLatinMap.get(character));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}
