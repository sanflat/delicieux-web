package com.family.delicieux.controller;

import com.family.delicieux.form.RecipeForm;
import com.family.delicieux.form.RecipeSetForm;
import com.family.delicieux.model.RecipeSetModel;
import com.family.delicieux.service.RecipeSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipe_set")
public class RecipeSetController {

    private final RecipeSetService recipeSetService;

    @Autowired
    public RecipeSetController(RecipeSetService recipeSetService){
        this.recipeSetService = recipeSetService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<RecipeSetModel> recipeSetModelList = recipeSetService.getRecipeSetListView();
        model.addAttribute("recipeSetList",recipeSetModelList);
        return "recipe_set/list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RecipeSetForm recipeSetForm = recipeSetService.getRecipeSetRegisterView(new RecipeSetForm());
        model.addAttribute("recipeSetForm", recipeSetForm);
        return "recipe_set/register";
    }

    @PostMapping("/post")
    public String register(RecipeSetForm recipeSetForm) {
        recipeSetService.postRecipeSet(recipeSetForm);
        return "redirect:/recipe_set/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        RecipeSetForm recipeSetForm = recipeSetService.getRecipeDetailOrUpdateView(id);
        model.addAttribute("recipeSetForm",recipeSetForm);
        return "recipe_set/detail";
    }

    @PostMapping("/update/post")
    public String update(RecipeSetForm recipeSetForm) {
        recipeSetService.updateRecipeSet(recipeSetForm);
        return "redirect:/recipe_set/list";
    }

}
