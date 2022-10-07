package com.example.BrewApp_1.product;

import com.example.BrewApp_1.recipe.Recipe;
import com.example.BrewApp_1.recipe.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private RecipeRepository recipeRepo;

    @GetMapping("/product_list")
    public String getProducts(Model model) {
        List<Product> lProd = prodRepo.findAll();
        model.addAttribute("product", lProd);
        return "product_list";
    }

    @GetMapping({"/createProduct/{recipeId}"})
    public ModelAndView createProduct(@PathVariable("recipeId") Long id){
        ModelAndView mav = new ModelAndView("product_add");
        Recipe recipe = recipeRepo.findByRecipeId(id);
        mav.addObject("recipe", recipe);
        Product newProduct = new Product();
        mav.addObject("newProduct", newProduct);
        return mav;
    }

    @PostMapping({"/saveProduct/{recipeId}"})
    public String saveProduct(@PathVariable("recipeId") Long id, Product product){
        Recipe recipeId = recipeRepo.findById(id).get();
        product.setRecipe(recipeId);
        prodRepo.save(product);
        return "redirect:/product_list";
    }
    @GetMapping("/detailProduct/{id}/{recipeId}")
    public ModelAndView getSingleProduct(@PathVariable("id") Long id, @PathVariable("recipeId") Long recipeId){
        ModelAndView mav = new ModelAndView("product_update");
        Recipe recipe = recipeRepo.findByRecipeId(recipeId);
        mav.addObject("recipe",recipe);
        Product product = prodRepo.findById(id).get();
        mav.addObject("product",product);
        return mav;
    }

    @PostMapping({"/updateProduct/{id}/{recipeId}"})
    public String saveProduct(Product product, @PathVariable("recipeId") Long recipeId){
        Recipe rId = recipeRepo.findById(recipeId).get();
        product.setRecipe(rId);
        prodRepo.save(product);
        return "redirect:/product_list";
    }

    @GetMapping({"/deleteProduct/{id}"})
    public String deleteProduct(@PathVariable("id") Long id){
        prodRepo.deleteById(id);
        return "redirect:/product_list";
    }
    @GetMapping({"/getGraph"})
    public String getGraphRawMade(Model model){

        List<String> rawList = prodRepo.findRawName();
        model.addAttribute("raw", rawList);

        List<String> dateMade = prodRepo.findDateMade();
        model.addAttribute("dateMade", dateMade);

        List<String> dateMade1 = prodRepo.findDateMade1();
        model.addAttribute("dateMade1", dateMade1);

        List<Integer> made1 = prodRepo.findMade1();
        model.addAttribute("made1", made1);

        List<Integer> made2 = prodRepo.findMade2();
        model.addAttribute("made2", made2);

        List<Integer> made3 = prodRepo.findMade3();
        model.addAttribute("made3", made3);

        List<Integer> made4 = prodRepo.findMade4();
        model.addAttribute("made4", made4);

        List<String> typeList = prodRepo.findRecipeType();
        model.addAttribute("type",typeList);

        List<Integer> amountList = prodRepo.findAmountMade();
        model.addAttribute("amount", amountList);

        return "graph";
    }


}
