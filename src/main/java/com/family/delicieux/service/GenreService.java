package com.family.delicieux.service;

import com.family.delicieux.form.GenreForm;
import com.family.delicieux.model.GenreModel;
import com.family.delicieux.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<GenreForm> getGenreListView(){
        List<GenreForm> genreFormList = new ArrayList<>();
        List<GenreModel> genrelModelList = genreRepository.selectGenreAll();
        for(GenreModel genre : genrelModelList){
            GenreForm genreForm = new GenreForm();
            genreForm.setId(genre.getId());
            genreForm.setName(genre.getName());
            genreFormList.add(genreForm);
        }
        return genreFormList;
    }

    public void postGenre(GenreForm genreForm){
        GenreModel genreModel = new GenreModel();
        genreModel.setId(genreForm.getId());
        genreModel.setName(genreForm.getName());
        genreRepository.insertGenre(genreModel);
    }

    public List<GenreModel> getGenreMstData(){
        return genreRepository.selectGenreAll();
    }

}
