package com.family.delicieux.service;

import com.family.delicieux.form.RecipeForm;
import com.family.delicieux.form.RecipeSetForm;
import com.family.delicieux.model.BoardModel;
import com.family.delicieux.model.RecipeModel;
import com.family.delicieux.model.RecipeSetRecipeBoardModel;
import com.family.delicieux.model.RecipeSetModel;
import com.family.delicieux.repository.RecipeSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeSetService {

    @Autowired
    private final RecipeService recipeService;
    private final BoardService boardService;
    private final RecipeSetRepository recipeSetRepository;
    private final RecipeSetRecipeBoardService recipeSetRecipeBoardService;
    public RecipeSetService(RecipeService recipeService, BoardService boardService, RecipeSetRepository recipeSetRepository, RecipeSetRecipeBoardService recipeSetRecipeBoardService){
        this.recipeService = recipeService;
        this.boardService = boardService;
        this.recipeSetRecipeBoardService = recipeSetRecipeBoardService;
        this.recipeSetRepository = recipeSetRepository;
    }

    public List<RecipeSetModel> getRecipeSetListView(){
        List<RecipeSetModel> recipeSetModelList = recipeSetRepository.selectRecipeSetAll();
        return recipeSetModelList;
    }

    public RecipeSetForm getRecipeSetRegisterView(RecipeSetForm recipeSetForm){
        List<RecipeModel> recipeMst = recipeService.getRecipeMstData();
        List<BoardModel> boards = boardService.getBoardMst();

        recipeSetForm.setSelectedRecipe(recipeMst);
        recipeSetForm.setBoards(boards);
        recipeSetForm.setSortable(getSortable(boards));

        return recipeSetForm;
    }

    public RecipeSetForm getRecipeDetailOrUpdateView(Integer recipeSetId){
        RecipeSetForm recipeSetForm = new RecipeSetForm();
        List<RecipeModel> recipeModelList = recipeService.getRecipeMstData();
        List<BoardModel> recipeListModelList = boardService.getBoardMst();
        RecipeSetModel recipeSetModel = recipeSetRepository.selectRecipeSetById(recipeSetId);
        List<RecipeSetRecipeBoardModel> recipeSetRecipeBoardModelList = recipeSetRecipeBoardService.selectRecipeSetRecipeBoardById(recipeSetId);

        recipeSetForm.setId(recipeSetModel.getId());
        recipeSetForm.setName(recipeSetModel.getName());
        recipeSetForm.setSelectedRecipe(recipeModelList);
        recipeSetForm.setBoards(recipeListModelList);
        recipeSetForm.setSortable(getSortable(recipeListModelList));
        recipeSetForm.setRecipeSetRecipeBoardList(recipeSetRecipeBoardModelList);

        return recipeSetForm;
    }

    public void postRecipeSet(RecipeSetForm recipeSetForm){
        //まずrecipe_setにレコードを追加する
        RecipeSetModel recipeSetModel = new RecipeSetModel();
        recipeSetModel.setName(recipeSetForm.getName());
        //追加したレコードのIDを取得する
        int recipeSetId = recipeSetRepository.insertRecipeSet(recipeSetModel);
        //recipe_recipe_setの登録
        for(String recipeSet : recipeSetForm.getRecipeSet()){
            //文字列の分解 SELECTED:ID ※「:」で分解
            String[] array = recipeSet.split(":");
            //SELECTEDから、recipe_listのIDを取得
            BoardModel board = boardService.getBoardByName(array[0]);
            //recipe_recipe_setに、レコードのID、recipe_listのID、レシピのIDを登録する
            RecipeSetRecipeBoardModel recipeSetRecipeBoardModel = new RecipeSetRecipeBoardModel();
            recipeSetRecipeBoardModel.setRecipeSetId(recipeSetId);
            recipeSetRecipeBoardModel.setRecipeId(Integer.parseInt(array[1]));
            recipeSetRecipeBoardModel.setBoardId(board.getId());
            recipeSetRecipeBoardService.postRecipeSetRecipeBoard(recipeSetRecipeBoardModel);
        }
    }

    private String getSortable(List<BoardModel> recipeListModelList){
        StringBuilder sortable = new StringBuilder();
        for(int i = 0; i < recipeListModelList.size(); i++){
            if(i == 0){
                sortable.append("[")
                        .append("\"")
                        .append(recipeListModelList.get(i).getName())
                        .append("\"");
                continue;
            }
            sortable.append(",")
                    .append("\"")
                    .append(recipeListModelList.get(i).getName())
                    .append("\"");
            if(i == recipeListModelList.size()-1){
                sortable.append("]");
            }
        }
        return sortable.toString();
    }

    public void updateRecipeSet(RecipeSetForm recipeSetForm){
        RecipeSetModel recipeSetModel = new RecipeSetModel();
        recipeSetModel.setId(recipeSetForm.getId());
        recipeSetModel.setName(recipeSetForm.getName());
        recipeSetRepository.updateRecipeSet(recipeSetModel);
        recipeSetRecipeBoardService.deleteRecipeSetRecipeBoard(recipeSetForm.getId());
        for(String recipeSet : recipeSetForm.getRecipeSet()){
            String[] array = recipeSet.split(":");
            BoardModel board = boardService.getBoardByName(array[0]);
            RecipeSetRecipeBoardModel recipeSetRecipeBoardModel = new RecipeSetRecipeBoardModel();
            recipeSetRecipeBoardModel.setRecipeSetId(recipeSetForm.getId());
            recipeSetRecipeBoardModel.setRecipeId(Integer.parseInt(array[1]));
            recipeSetRecipeBoardModel.setBoardId(board.getId());
            recipeSetRecipeBoardService.postRecipeSetRecipeBoard(recipeSetRecipeBoardModel);
        }
    }
}
