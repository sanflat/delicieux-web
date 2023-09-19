package com.family.delicious_food_recipes.service;
import com.family.delicious_food_recipes.model.RecipeModel;
import com.family.delicious_food_recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public void getRecipeList(Model model){
        List<RecipeModel> recipeList = recipeRepository.getRecipeList();
        model.addAttribute("recipeList",recipeList);
    }
}
