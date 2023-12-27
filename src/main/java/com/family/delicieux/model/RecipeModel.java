package com.family.delicieux.model;

import lombok.Data;

import java.util.Date;
@Data
public class RecipeModel {
    private Integer id;
    private String name;
    private Integer breakfastFlg;
    private Integer lunchFlg;
    private Integer dinnerFlg;
    private String material;
    private String spices;
    private String cook;
    private Integer seasonId;
    private Integer genreId;
    private String memo;
    private Date deletedAt;
    private Date createdAt;
    private Date updatedAt;
}
