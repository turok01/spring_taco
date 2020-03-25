package com.Igor.spring_taco.controller;

import com.Igor.spring_taco.Ingredient;
import com.Igor.spring_taco.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }
    @Override
    public Ingredient convert(String id){
        return ingredientRepo.findOne(id);
    }
}
