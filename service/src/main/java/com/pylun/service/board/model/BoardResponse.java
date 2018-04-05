package com.pylun.service.board.model;

import com.pylun.board.model.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class BoardResponse
{
    private long totalCount;
    private List<Board> items;

    @Builder
    public BoardResponse(long totalCount, List<Board> items) {
        this.totalCount = totalCount;
        this.items = items;
    }
}
