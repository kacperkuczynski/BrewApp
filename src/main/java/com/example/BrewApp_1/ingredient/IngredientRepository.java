package com.example.BrewApp_1.ingredient;

import com.example.BrewApp_1.raw.Raw;
import com.example.BrewApp_1.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Query(value = "SELECT i FROM Ingredient i JOIN i.raw w WHERE i.recipe = ?1")
    List<Object> findIngredientByRecipe(Recipe r);
    @Query(value = "DELETE FROM Ingredient i WHERE i.id = :id")
    Long deleteIngredient(@Param("id")Long id);

}
