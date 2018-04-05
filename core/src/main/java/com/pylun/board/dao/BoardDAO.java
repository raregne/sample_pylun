package com.pylun.board.dao;

import com.pylun.board.model.Board;
import com.pylun.board.model.BoardLog;
import com.pylun.board.model.BoardParam;
import com.pylun.board.model.BoardEx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDAO
{
    Board getBoard(BoardParam boardParam);

    int insertBoard(Board board);

    long listBoardTotalCount(BoardParam boardParam);

    List<Board> listBoard(BoardParam boardParam);

    int updateBoard(Board board);

    BoardLog getBoardLog(BoardParam boardParam);

    int insertBoardLog(BoardLog boardLog);


    BoardEx getBoardEx(BoardParam boardParam);

    List<BoardEx> listBoardEx(BoardParam boardParam);
}
