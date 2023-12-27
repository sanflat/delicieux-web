package com.family.delicieux.form;

import com.family.delicieux.model.GenreModel;
import com.family.delicieux.model.SeasonModel;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class RecipeForm {
    private Integer id;
    private String name;
    private Integer breakfastFlg;
    private Integer lunchFlg;
    private Integer dinnerFlg;
    private String material;
    private String spices;
    private String cook;
    private Integer seasonId;
    private String season;
    private Integer genreId;
    private String genre;
    private String memo;
    private List<GenreModel> genreList;
    private List<SeasonModel> seasonList;
}
