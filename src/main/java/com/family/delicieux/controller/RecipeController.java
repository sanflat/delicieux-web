package com.family.delicieux.controller;

import com.family.delicieux.form.RecipeForm;
import com.family.delicieux.model.RecipeModel;
import com.family.delicieux.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<RecipeForm> recipeList = recipeService.getRecipeListView();
        model.addAttribute("recipeList", recipeList);
        return "recipe/list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RecipeForm recipeForm = recipeService.gerRegisterView();
        model.addAttribute("recipeForm", recipeForm);
        return "recipe/register";
    }

    @PostMapping("/post")
    public String register(RecipeForm recipeForm) {
        recipeService.postRecipe(recipeForm);
        return "redirect:/recipe/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        RecipeForm recipe = recipeService.getRecipeDetailOrUpdateView(id);
        model.addAttribute("recipe",recipe);
        return "recipe/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        RecipeForm recipe = recipeService.getRecipeDetailOrUpdateView(id);
        model.addAttribute("recipe",recipe);
        return "recipe/update";
    }

    @PutMapping("/update/put")
    public String update(RecipeForm recipeForm) {
        recipeService.putRecipe(recipeForm);
        return "redirect:/recipe/list";
    }

}
