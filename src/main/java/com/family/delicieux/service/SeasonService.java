package com.family.delicieux.service;

import com.family.delicieux.form.SeasonForm;
import com.family.delicieux.model.SeasonModel;
import com.family.delicieux.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeasonService {

    private final SeasonRepository seasonRepository;
    @Autowired
    public SeasonService(SeasonRepository seasonRepository){
        this.seasonRepository = seasonRepository;
    }

    public List<SeasonForm> getSeasonListView(){
        List<SeasonForm> seasonFormList = new ArrayList<>();
        List<SeasonModel> seasonModelList = seasonRepository.seasonAllData();
        for (SeasonModel season : seasonModelList){
            SeasonForm seasonForm = new SeasonForm();
            seasonForm.setId(season.getId());
            seasonForm.setName(season.getName());
            seasonFormList.add(seasonForm);
        }
        return seasonFormList;
    }

    public void postSeason(SeasonForm seasonForm){
        SeasonModel seasonModel = new SeasonModel();
        seasonModel.setId(seasonForm.getId());
        seasonModel.setName(seasonForm.getName());
        seasonRepository.insertSeason(seasonModel);
    }

    public List<SeasonModel> getSeasonMstData(){
        return seasonRepository.seasonAllData();
    }
}
