package com.family.delicieux.repository;

import com.family.delicieux.model.RecipeSetRecipeBoardModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeSetRecipeBoardRepository {
    void delete(Integer recipeSetId);
    void insert(RecipeSetRecipeBoardModel recipeSetRecipeBoardModel);
    List<RecipeSetRecipeBoardModel> selectRecipeSetRecipeBoardById(Integer recipeSetId);
}
