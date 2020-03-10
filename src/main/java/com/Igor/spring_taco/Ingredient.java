package com.Igor.spring_taco;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data //Lombok generate all methods like equals(), hashCode(), toString()
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;
    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
