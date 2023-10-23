package com.family.delicious_food_recipes.model;

import lombok.Data;
import com.family.delicious_food_recipes.model.MaterialModel;

import java.util.List;

@Data
public class RecipeModel {

    private Integer id;
    private String name;
    private boolean breakfastFlg;
    private boolean lunchFlg;
    private boolean dinnerFlg;
    private String material;
    private List<MaterialModel> materialModelList;
    private String spices;
    private String cook;
    private Integer seasonId;
    private String season;
    private Integer genreId;
    private String genre;
    private String memo;
}
