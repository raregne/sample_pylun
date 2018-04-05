package com.pylun.board.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Board
{
    @ApiModelProperty(notes = "고유 번호", example = "1")
    private long borIdx;
    @ApiModelProperty(notes = "삭제여부 (0:none / 1:삭제)", example = "1")
    private long borDelFlag;
    @ApiModelProperty(notes = "데이터 등록시간", example = "2018-01-01 01:00:00")
    private LocalDate borInsertDate;
    @ApiModelProperty(notes = "데이터 수정시간", example = "2018-01-01 01:00:00")
    private LocalDate borUpdateDate;
    @ApiModelProperty(notes = "데이터 삭제시간", example = "2018-01-01 01:00:00")
    private LocalDate borDeleteDate;
    @ApiModelProperty(notes = "삭제여부 (0:none / 1:삭제)", example = "1")
    private long borState;
    @ApiModelProperty(notes = "제목", example = "제목")
    private String borSubject;
    @ApiModelProperty(notes = "본문내용", example = "본문내용")
    private String borContent;
    @ApiModelProperty(notes = "부모 게시판 (borad table index)", example = "1")
    private long borParentIdx;
    @ApiModelProperty(notes = "게시판 카테고리", example = "QnA")
    private String borCategory;
}
