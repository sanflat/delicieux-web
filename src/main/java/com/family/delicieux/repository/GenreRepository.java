package com.family.delicieux.repository;

import com.family.delicieux.model.GenreModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenreRepository {
    List<GenreModel> selectGenreAll();
    void insertGenre(GenreModel genreModel);
}
