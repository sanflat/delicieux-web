package com.family.delicious_food_recipes.repository;

import com.family.delicious_food_recipes.model.RecipeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeRepository {
    List<RecipeModel> getRecipeList();
}
