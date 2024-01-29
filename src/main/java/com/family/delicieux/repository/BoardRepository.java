package com.family.delicieux.repository;

import com.family.delicieux.model.BoardModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {
    List<BoardModel> selectBoardAll();
    BoardModel selectBoardByName(String name);
}
