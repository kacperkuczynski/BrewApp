package com.example.BrewApp_1.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepo;
    List<Recipe> recipes = Arrays.asList();
    Map<Long,List<Recipe>> groupedById = recipes.stream().collect(Collectors.groupingBy(Recipe::getId));
}
