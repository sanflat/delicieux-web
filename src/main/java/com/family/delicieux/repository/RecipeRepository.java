package com.family.delicieux.repository;

import com.family.delicieux.model.RecipeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeRepository {
    List<RecipeModel> getRecipeAllData();

    RecipeModel getRecipeFindId(Integer id);

    void insertRecipe(RecipeModel recipeModel);

    void updateRecipe(RecipeModel recipeModel);
}
