package com.example.BrewApp_1.ingredient;

import com.example.BrewApp_1.recipe.Recipe;

import java.util.List;
import java.util.Optional;


public interface IngredientService {
    Optional<Ingredient> findById(Long aLong);


}
