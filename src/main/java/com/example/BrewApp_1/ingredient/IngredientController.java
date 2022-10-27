package com.example.BrewApp_1.ingredient;

import com.example.BrewApp_1.raw.Raw;
import com.example.BrewApp_1.recipe.Recipe;
import com.example.BrewApp_1.raw.RawRepository;
import com.example.BrewApp_1.recipe.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IngredientController {
    @Autowired
    private RawRepository rawRepo;
    @Autowired
    private RecipeRepository recipeRepo;
    @Autowired
    private final IngredientRepository ingrRepo;

    @GetMapping(value = "/addIngredient/{recipeId}")
    public String addIngredient(@PathVariable(value = "recipeId") Long id, Model model){
        Recipe recipe = recipeRepo.findByRecipeId(id);
        model.addAttribute("recipe", recipe);

        Ingredient ingredient = new Ingredient();
        model.addAttribute("newIngredient", ingredient);

        List<Raw> lRawType = rawRepo.findAll();
        model.addAttribute("listRaw", lRawType);

        return "ingredient_add";
    }

    @PostMapping({"/addIngredient/{recipeId}/{rawId}"})
    public String addIngredient(@PathVariable(value = "rawId") Long rawId,
                                @PathVariable(value = "recipeId") Long recipeId,
                                Ingredient ingredient){
        Recipe recipe = recipeRepo.findById(recipeId).get();
        ingredient.setRecipe(recipe);
        Raw raw = rawRepo.findById(rawId).get();
        ingredient.setRaw(raw);
        ingrRepo.save(ingredient);
        return "redirect:/detailRecipe/{recipeId}";
    }

    @GetMapping("/detailIngredient/{id}/{recipeId}/{rawId}")
    public ModelAndView getSingleIngredient(@PathVariable("id") Long id,
                                            @PathVariable("rawId") Long rawId,
                                            @PathVariable("recipeId") Long recipeId){
        ModelAndView mav = new ModelAndView("ingredient_update");
        Ingredient ingredient = ingrRepo.findById(id).get();
        mav.addObject("newIngredient",ingredient);
        return mav;
    }

    @PostMapping({"/updateIngredient/{id}/{rawId}/{recipeId}"})
    public String saveIngredient(Ingredient ingredient,
                              @PathVariable("id") Long id,
                              @PathVariable("rawId") Long rawId,
                              @PathVariable("recipeId") Long recipeId){
        Raw raId = rawRepo.findById(rawId).get();
        Recipe recId = recipeRepo.findById(recipeId).get();
        ingredient.setRaw(raId);
        ingredient.setRecipe(recId);
        ingrRepo.save(ingredient);
        return "redirect:/recipe_detail";
    }

    @GetMapping({"/deleteIngredient/{id}/{recipeId}"})
    public String deleteIngredient(@PathVariable("id") Long id,
                                   @PathVariable("recipeId") Long recipeId){
        ingrRepo.deleteById(id);
        return "redirect:/detailRecipe/{recipeId}";
    }



}
