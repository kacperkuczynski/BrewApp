package com.example.BrewApp_1.recipe;

import com.example.BrewApp_1.ingredient.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeRepository recipeRepo;
    private final IngredientRepository ingrRepo;

    @GetMapping("/recipes")
    public ModelAndView getRecipes() {
        ModelAndView mav = new ModelAndView("recipe_list");
        List<Recipe> lRecipes = recipeRepo.findAll();
        mav.addObject("recipe", lRecipes);
        return mav;
    }

    @GetMapping({"/addRecipe"})
    public ModelAndView addRecipe(){
        ModelAndView mav = new ModelAndView("recipe_add");
        Recipe newRecipe = new Recipe();
        mav.addObject("recipe", newRecipe);
        return mav;
    }

    @PostMapping({"/saveRecipe"})
    public String saveRecipe(@ModelAttribute Recipe recipe){
        recipeRepo.save(recipe);
        return "redirect:/recipes";
    }
    @GetMapping("/editRecipe/{recipeId}")
    public String getSingleRecipe(@PathVariable("recipeId") Long recipeId, Model model){
        Recipe recipe = recipeRepo.findByRecipeId(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipe_edit";
    }

    @GetMapping({"/detailRecipe/{recipeId}"})
    public String detailRecipe(@PathVariable(value = "recipeId") Long recipeId, Model model) {
        Recipe recipe = recipeRepo.findByRecipeId(recipeId);
        model.addAttribute("recipe", recipe);
        List<Object> ingredient = ingrRepo.findIngredientByRecipe(recipe);
        model.addAttribute("ingredient", ingredient);
        return "recipe_detail";
        }
    @GetMapping({"/deleteRecipe/{recipeId}"})
    public String deleteIngredient(@PathVariable("recipeId") Long recipeId){
        recipeRepo.deleteById(recipeId);
        return "redirect:/recipes";
    }
    }


