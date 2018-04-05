package com.pylun.board.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BoardComment
{
    @ApiModelProperty(notes = "고유 번호", example = "1")
    private long borcIdx;
    @ApiModelProperty(notes = "삭제여부 (0:none / 1:삭제)", example = "1")
    private long borcDelFlag;
    @ApiModelProperty(notes = "데이터 등록시간", example = "2018-01-01 01:00:00")
    private LocalDate borcInsertDate;
    @ApiModelProperty(notes = "데이터 수정시간", example = "2018-01-01 01:00:00")
    private LocalDate borcUpdateDate;
    @ApiModelProperty(notes = "데이터 삭제시간", example = "2018-01-01 01:00:00")
    private LocalDate borcDeleteDate;
    @ApiModelProperty(notes = "삭제여부 (0:none / 1:삭제)", example = "1")
    private long borcState;
    @ApiModelProperty(notes = "본문내용", example = "본문내용")
    private String borcContent;
}
