package com.family.delicious_food_recipes.controller;

import com.family.delicious_food_recipes.model.GenreModel;
import com.family.delicious_food_recipes.model.RecipeModel;
import com.family.delicious_food_recipes.model.SeasonModel;
import com.family.delicious_food_recipes.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AllController {

    @Autowired
    AllService allService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/recipe/list")
    public String recipe_list(Model model) {
        List<RecipeModel> recipeList = allService.recipe_list();
        model.addAttribute("recipeList", recipeList);
        return "recipe/list";
    }

    @GetMapping("/recipe/register")
    public String recipe_register(Model model) {
        RecipeModel recipeModel = new RecipeModel();
        List<SeasonModel> seasonList = allService.season_list();
        List<GenreModel> genreList = allService.genre_list();
        model.addAttribute("recipeModel", recipeModel);
        model.addAttribute("seasonList", seasonList);
        model.addAttribute("genreList", genreList);
        return "recipe/register";
    }

    @GetMapping("/recipe/detail/{id}")
    public String recipe_detail(@PathVariable Integer id, Model model) {
        RecipeModel recipe = allService.recipe_detail(id);
        model.addAttribute("recipe",recipe);
        return "recipe/detail";
    }

    @GetMapping("/recipe/update/{id}")
    public String recipe_update(@PathVariable Integer id, Model model) {
        RecipeModel recipe = allService.recipe_detail(id);
        List<SeasonModel> seasonList = allService.season_list();
        List<GenreModel> genreList = allService.genre_list();
        model.addAttribute("recipeModel", recipe);
        model.addAttribute("seasonList", seasonList);
        model.addAttribute("genreList", genreList);
        return "recipe/update";
    }

    @PostMapping("/recipe/post")
    public String recipe_post(RecipeModel recipeModel) {
        allService.recipe_post(recipeModel);
        return "redirect:/recipe/list";
    }

    @PostMapping("/recipe/update/post")
    public String recipe_update_post(RecipeModel recipeModel) {
        allService.recipe_update_post(recipeModel);
        return "redirect:/recipe/list";
    }

    @GetMapping("/season/list")
    public String season_list(Model model) {
        List<SeasonModel> seasonList = allService.season_list();
        model.addAttribute("seasonList", seasonList);
        return "season/list";
    }

    @GetMapping("/season/register")
    public String season_register(Model model) {
        SeasonModel seasonModel = new SeasonModel();
        model.addAttribute("seasonModel", seasonModel);
        return "season/register";
    }

    @PostMapping("/season/post")
    public String season_post(@ModelAttribute SeasonModel seasonModel) {
        allService.season_post(seasonModel);
        return "redirect:/season/list";
    }

    @GetMapping("/genre/list")
    public String genre_list(Model model) {
        List<GenreModel> genreList = allService.genre_list();
        model.addAttribute("genreList", genreList);
        return "genre/list";
    }

    @GetMapping("/genre/register")
    public String genre_register(Model model) {
        GenreModel genreModel = new GenreModel();
        model.addAttribute("genreModel", genreModel);
        return "genre/register";
    }

    @PostMapping("/genre/post")
    public String genre_post(@ModelAttribute GenreModel genreModel) {
        allService.genre_post(genreModel);
        return "redirect:/genre/list";
    }
}
