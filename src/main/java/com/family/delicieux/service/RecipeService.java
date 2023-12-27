package com.family.delicieux.service;

import com.family.delicieux.form.RecipeForm;
import com.family.delicieux.model.GenreModel;
import com.family.delicieux.model.RecipeModel;
import com.family.delicieux.model.SeasonModel;
import com.family.delicieux.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final GenreService genreService;
    private final SeasonService seasonService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository,
                         GenreService genreService,
                         SeasonService seasonService){
        this.recipeRepository = recipeRepository;
        this.genreService = genreService;
        this.seasonService = seasonService;
    }

    public List<RecipeForm> getRecipeListView(){
        List<RecipeForm> recipeFormList = new ArrayList<>();
        List<RecipeModel> recipeModelList = recipeRepository.getRecipeAllData();
        List<GenreModel> genreModelList = genreService.getGenreMstData();
        List<SeasonModel> seasonModelList = seasonService.getSeasonMstData();
        for(RecipeModel recipe : recipeModelList){
            RecipeForm recipeForm = getRecipeForm(recipe);
            getGenreName(genreModelList, recipeForm);
            getSeasonName(seasonModelList,recipeForm);
            recipeFormList.add(recipeForm);
        }
        return recipeFormList;
    }

    public RecipeForm getRecipeDetailOrUpdateView(Integer id){
        RecipeModel recipe = recipeRepository.getRecipeFindId(id);
        RecipeForm recipeForm = getRecipeForm(recipe);
        List<GenreModel> genreModelList = genreService.getGenreMstData();
        List<SeasonModel> seasonModelList = seasonService.getSeasonMstData();
        getGenreName(genreModelList, recipeForm);
        getSeasonName(seasonModelList,recipeForm);
        recipeForm.setGenreList(genreModelList);
        recipeForm.setSeasonList(seasonModelList);
        return recipeForm;
    }

    public RecipeForm gerRegisterView(){
        RecipeForm recipeForm = new RecipeForm();
        List<GenreModel> genreModelList = genreService.getGenreMstData();
        List<SeasonModel> seasonModelList = seasonService.getSeasonMstData();
        recipeForm.setGenreList(genreModelList);
        recipeForm.setSeasonList(seasonModelList);
        return recipeForm;
    }

    public void postRecipe(RecipeForm recipeForm){
        recipeRepository.insertRecipe(setRecipeModel(recipeForm));
    }

    public void putRecipe(RecipeForm recipeForm){
        recipeRepository.updateRecipe(setRecipeModel(recipeForm));
    }

    private RecipeModel setRecipeModel(RecipeForm form){
        RecipeModel model = new RecipeModel();
        if(Objects.nonNull(form.getId())){
            model.setId(form.getId());
        }
        model.setName(form.getName());
        model.setBreakfastFlg(form.getBreakfastFlg());
        model.setLunchFlg(form.getLunchFlg());
        model.setDinnerFlg(form.getDinnerFlg());
        model.setMaterial(form.getMaterial());
        model.setSpices(form.getSpices());
        model.setCook(form.getCook());
        model.setSeasonId(form.getSeasonId());
        model.setGenreId(form.getGenreId());
        model.setMemo(form.getMemo());
        return model;
    }

    private RecipeForm getRecipeForm(RecipeModel recipe) {
        RecipeForm form = new RecipeForm();
        form.setId(recipe.getId());
        form.setName(recipe.getName());
        form.setBreakfastFlg(recipe.getBreakfastFlg());
        form.setLunchFlg(recipe.getLunchFlg());
        form.setDinnerFlg(recipe.getDinnerFlg());
        form.setMaterial(recipe.getMaterial());
        form.setSpices(recipe.getSpices());
        form.setCook(recipe.getCook());
        form.setSeasonId(recipe.getSeasonId());
        form.setGenreId(recipe.getGenreId());
        form.setMemo(recipe.getMemo());
        return form;
    }

    private void getGenreName(List<GenreModel> genreModelList, RecipeForm form){
        Optional<Integer> optGenreId = Optional.ofNullable(form.getGenreId());
        if(optGenreId.isPresent()) {
            for (GenreModel genre : genreModelList) {
                if (genre.getId().equals(form.getGenreId())) {
                    form.setGenre(genre.getName());
                }
            }
        }
    }

    private void getSeasonName(List<SeasonModel> seasonModelList, RecipeForm form){
        Optional<Integer> optSeasonId = Optional.ofNullable(form.getSeasonId());
        if(optSeasonId.isPresent()){
            for(SeasonModel season : seasonModelList){
                if(season.getId().equals(form.getSeasonId())){
                    form.setSeason(season.getName());
                }
            }
        }
    }
}
