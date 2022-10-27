package com.example.BrewApp_1.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Override
    Optional<Recipe> findById(Long aLong);

   @Query(value = "SELECT r FROM Recipe r WHERE r.id = ?1")
   Recipe findByRecipeId(Long recipeId);



}
