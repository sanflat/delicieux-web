package com.family.delicieux.repository;

import com.family.delicieux.model.RecipeSetModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeSetRepository {

    List<RecipeSetModel> selectRecipeSetAll();
    RecipeSetModel selectRecipeSetById(Integer id);
    int insertRecipeSet(RecipeSetModel recipeSetModel);
    void updateRecipeSet(RecipeSetModel recipeSetModel);
}
