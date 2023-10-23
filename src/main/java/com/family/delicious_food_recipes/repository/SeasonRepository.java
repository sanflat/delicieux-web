package com.family.delicious_food_recipes.repository;

import com.family.delicious_food_recipes.model.SeasonModel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SeasonRepository {
    List<SeasonModel> season_list();

    void season_post(SeasonModel seasonModel);
}
