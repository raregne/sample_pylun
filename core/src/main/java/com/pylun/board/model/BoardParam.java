package com.pylun.board.model;

import com.pylun.service.common.model.Pager;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardParam extends Pager
{
    @ApiModelProperty(notes = "고유 번호", example = "1")
    private long borIdx;
    @ApiModelProperty(notes = "삭제여부 (0:none / 1:삭제)", example = "1")
    private long borState;
    @ApiModelProperty(notes = "검색구분", example = "subject")
    private String searchType;
    @ApiModelProperty(notes = "검색어", example = "보드")
    private String searchValue;
}
