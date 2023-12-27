package com.family.delicieux.repository;

import com.family.delicieux.model.SeasonModel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SeasonRepository {
    List<SeasonModel> seasonAllData();

    void insertSeason(SeasonModel seasonModel);
}
