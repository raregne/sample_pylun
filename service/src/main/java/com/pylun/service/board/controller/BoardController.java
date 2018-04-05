package com.pylun.service.board.controller;

import com.pylun.board.model.Board;
import com.pylun.board.model.BoardParam;
import com.pylun.board.service.BoardService;
import com.pylun.service.board.model.BoardResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BoardController
{
    static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;


    @GetMapping(value = "/api/board/{borIdx}")
    public Board getBoards(@PathVariable long borIdx)
    {
        //logger.info("BoardController /detail");
        BoardParam boardParam = new BoardParam();
        boardParam.setBorIdx(borIdx);
        Board board = boardService.getBoard(boardParam);

        return board;
    }


    @GetMapping(value = "/api/boards")
    public BoardResponse listBoard(@ModelAttribute BoardParam boardParam)
    {
        //logger.info("BoardController /api/boards");

        long totalCount = boardService.listBoardTotalCount(boardParam);
        List<Board> listBoard = null;
        if (totalCount > 0)
        {
            listBoard = boardService.listBoard(boardParam);
        }
        return new BoardResponse(totalCount, listBoard);
    }

    @PostMapping(value = "/api/boards")
    public Board insertBoard(@ModelAttribute Board board) throws Exception
    {
        //logger.info("BoardController /productadd");
        int resultCnt = boardService.insertBoard(board);
        return board;
    }

    @PutMapping(value = "/api/boards")
    public Board updateBoard(@ModelAttribute Board board) throws Exception
    {
        //logger.info("BoardController /productadd");

        int resultCnt = boardService.updateBoard(board);
        return board;
    }

}
