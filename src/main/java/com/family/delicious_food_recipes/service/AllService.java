package com.family.delicious_food_recipes.service;
import com.family.delicious_food_recipes.model.*;
import com.family.delicious_food_recipes.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.List;

@Service
public class AllService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @Autowired
    GenreRepository genreRepository;

    public List<RecipeModel> recipe_list(){
        List<RecipeModel> recipeModelList = recipeRepository.recipe_list();
        List<SeasonModel> seasonModelList = seasonRepository.season_list();
        List<GenreModel> genreModelList = genreRepository.genre_list();
        for(RecipeModel recipeModel:recipeModelList){
            if(recipeModel.getSeasonId() != null){
                for(SeasonModel seasonModel:seasonModelList){
                    if(seasonModel.getId() == recipeModel.getSeasonId()){
                        recipeModel.setSeason(seasonModel.getName());
                    }
                }
            }

            if(recipeModel.getGenreId() != null){
                for(GenreModel genreModel:genreModelList){
                    if(genreModel.getId() == recipeModel.getGenreId()){
                        recipeModel.setGenre(genreModel.getName());
                    }
                }
            }
        }

        return recipeModelList;
    }

    public RecipeModel recipe_detail(Integer id){
        return recipeRepository.recipe_detail(id);
    }

    public void recipe_post(RecipeModel recipeModel){
        recipeRepository.recipe_post(recipeModel);
    }

    public void recipe_update_post(RecipeModel recipeModel){
        recipeRepository.recipe_update_post(recipeModel);
    }

    public List<SeasonModel> season_list(){
        List<SeasonModel> seasonModelList = seasonRepository.season_list();
        return seasonModelList;
    }

    public void season_post(SeasonModel seasonModel){
        seasonRepository.season_post(seasonModel);
    }

    public List<GenreModel> genre_list(){
        List<GenreModel> genreModelList = genreRepository.genre_list();
        return genreModelList;
    }
    public void genre_post(GenreModel genreModel){
        genreRepository.genre_post(genreModel);
    }

}
