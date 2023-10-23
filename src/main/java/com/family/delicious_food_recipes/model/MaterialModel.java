package com.family.delicious_food_recipes.model;

import lombok.Data;

@Data
public class MaterialModel {

    private Integer id;
    private Integer recipeId;
    private Integer materialMstId;
    private double quantity;
    private String quantityUnit;

}
