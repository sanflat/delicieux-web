package com.family.delicieux.service;

import com.family.delicieux.model.RecipeSetRecipeBoardModel;
import com.family.delicieux.repository.RecipeSetRecipeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeSetRecipeBoardService {

    @Autowired
    private final RecipeSetRecipeBoardRepository recipeSetRecipeBoardRepository;
    public RecipeSetRecipeBoardService(RecipeSetRecipeBoardRepository recipeSetRecipeBoardRepository){
        this.recipeSetRecipeBoardRepository = recipeSetRecipeBoardRepository;
    }

    public void deleteRecipeSetRecipeBoard(Integer id){
        recipeSetRecipeBoardRepository.delete(id);
    }

    public void postRecipeSetRecipeBoard(RecipeSetRecipeBoardModel recipeRecipeSetModel){
        recipeSetRecipeBoardRepository.insert(recipeRecipeSetModel);
    }

    public List<RecipeSetRecipeBoardModel> selectRecipeSetRecipeBoardById(Integer recipeSetId){
        return recipeSetRecipeBoardRepository.selectRecipeSetRecipeBoardById(recipeSetId);
    }
}
