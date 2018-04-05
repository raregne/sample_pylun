package com.pylun.board.service;

import com.pylun.board.dao.BoardDAO;
import com.pylun.board.model.Board;
import com.pylun.board.model.BoardParam;
import com.pylun.board.model.BoardEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService
{
    @Autowired
    private BoardDAO boardDAO;

    public Board getBoard(BoardParam boardParam)
    {
        return boardDAO.getBoard(boardParam);
    }

    public int insertBoard(Board board)
    {
        return boardDAO.insertBoard(board);
    }

    public long listBoardTotalCount(BoardParam boardParam)
    {
        return boardDAO.listBoardTotalCount(boardParam);
    }

    public List<Board> listBoard(BoardParam boardParam)
    {
        return boardDAO.listBoard(boardParam);
    }

    public int updateBoard(Board board)
    {
        return boardDAO.updateBoard(board);
    }


    public BoardEx getBoardEx(BoardParam boardParam)
    {
        return boardDAO.getBoardEx(boardParam);
    }

    public List<BoardEx> listBoardEx(BoardParam boardParam)
    {
        return boardDAO.listBoardEx(boardParam);
    }
}
