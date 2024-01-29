package com.family.delicieux.form;

import com.family.delicieux.model.BoardModel;
import com.family.delicieux.model.RecipeModel;
import com.family.delicieux.model.RecipeSetRecipeBoardModel;
import lombok.Data;

import java.util.List;

@Data
public class RecipeSetForm {
    private Integer id;
    private String name;
    private List<String> recipeSet;
    private String sortable;
    private List<RecipeSetRecipeBoardModel> recipeSetRecipeBoardList;
    private List<BoardModel> boards;
    private List<RecipeModel> selectedRecipe;
}
