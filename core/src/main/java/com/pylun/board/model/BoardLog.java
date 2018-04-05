package com.pylun.board.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BoardLog
{
    @ApiModelProperty(notes = "고유 번호", example = "1")
    private long borlIdx;
    @ApiModelProperty(notes = "삭제여부 (0:none / 1:삭제)", example = "1")
    private long borlDelFlag;
    @ApiModelProperty(notes = "데이터 등록시간", example = "2018-01-01 01:00:00")
    private LocalDate borlInsertDate;
    @ApiModelProperty(notes = "데이터 수정시간", example = "2018-01-01 01:00:00")
    private LocalDate borlUpdateDate;
    @ApiModelProperty(notes = "데이터 삭제시간", example = "2018-01-01 01:00:00")
    private LocalDate borlDeleteDate;
    @ApiModelProperty(notes = "타입 (1 : 본문작성, 2: 본문수정, 3:노출여부(표시), 4:노출여부(블라인드), 5, 댓글 등록, 6 댓글 수정, 7 댓글 삭제, 8, 댓글 표시여부 (표시) , 9 댓글 표시여부 (블라인드)", example = "1")
    private String borlAct;
    @ApiModelProperty(notes = "사용자번호", example = "1")
    private long borlUserIdx;
    @ApiModelProperty(notes = "대상 테이블(0:board, 1:board_comment)", example = "0")
    private long borlRefererType;
    @ApiModelProperty(notes = "대상 고유 번호", example = "1")
    private long borlRefererIdx;
}
