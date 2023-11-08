package com.family.delicieux.model;

import lombok.Data;

@Data
public class MaterialModel {

    private Integer id;
    private Integer recipeId;
    private Integer materialMstId;
    private double quantity;
    private String quantityUnit;

}
