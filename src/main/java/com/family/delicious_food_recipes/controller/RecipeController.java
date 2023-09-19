package com.family.delicious_food_recipes.controller;

import com.family.delicious_food_recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/")
    public String posts(Model model) {
        recipeService.getRecipeList(model);
        return "index";
    }
}
