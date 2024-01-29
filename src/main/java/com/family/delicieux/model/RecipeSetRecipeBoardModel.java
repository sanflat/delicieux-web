package com.family.delicieux.model;

import lombok.Data;

@Data
public class RecipeSetRecipeBoardModel {
    private Integer recipeSetId;
    private Integer recipeId;
    private Integer boardId;
    private RecipeModel recipeModel;
}
