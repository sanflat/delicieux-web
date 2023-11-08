package com.family.delicieux.model;

import lombok.Data;

import java.util.List;

@Data
public class RecipeModel {

    private Integer id;
    private String name;
    private Integer breakfastFlg;
    private Integer lunchFlg;
    private Integer dinnerFlg;
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
