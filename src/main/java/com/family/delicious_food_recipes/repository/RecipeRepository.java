package com.family.delicious_food_recipes.repository;

import com.family.delicious_food_recipes.model.RecipeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeRepository {
    List<RecipeModel> recipe_list();

    RecipeModel recipe_detail(Integer id);

    void recipe_post(RecipeModel recipeModel);

    void recipe_update_post(RecipeModel recipeModel);
}
