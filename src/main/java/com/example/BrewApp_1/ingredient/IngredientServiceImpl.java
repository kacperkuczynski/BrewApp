package com.example.BrewApp_1.ingredient;

import com.example.BrewApp_1.recipe.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IngredientServiceImpl implements IngredientService{
    private final IngredientRepository ingrRepo;

    public IngredientServiceImpl(IngredientRepository ingrRepo) {
        this.ingrRepo = ingrRepo;
    }

    @Override
    public Optional<Ingredient> findById(Long aLong) {
        return ingrRepo.findById(aLong);
    }


}
