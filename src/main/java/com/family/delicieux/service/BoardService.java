package com.family.delicieux.service;

import com.family.delicieux.model.BoardModel;
import com.family.delicieux.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public List<BoardModel> getBoardMst(){
        return boardRepository.selectBoardAll();
    }

    public BoardModel getBoardByName(String name){
        return boardRepository.selectBoardByName(name);
    }
}
