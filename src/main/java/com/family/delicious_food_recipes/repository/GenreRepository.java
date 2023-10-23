package com.family.delicious_food_recipes.repository;

import com.family.delicious_food_recipes.model.GenreModel;
import com.family.delicious_food_recipes.model.RecipeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenreRepository {
    List<GenreModel> genre_list();
    void genre_post(GenreModel genreModel);
}
