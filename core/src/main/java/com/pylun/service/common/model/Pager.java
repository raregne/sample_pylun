package com.pylun.service.common.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

@Getter
@Setter
public class Pager
{
    @ApiModelProperty(value = "페이지 번호", example = "1", position = 1000)
    private Integer pageNumber = 1;

    @ApiModelProperty(value = "한 페이지당 노출 수", example = "10", position = 1001)
 //   @Max(value = 500)
    private Integer pageSize = 10;

    @ApiModelProperty(value = "목록 카운트 포함 여부(default: false)", position = 1002)
    private boolean hasTotalCount = false;

    @ApiIgnore
    public boolean hasTotalCount() {
        return hasTotalCount;
    }

    @ApiModelProperty(hidden = true)
    private int offset;

    @ApiModelProperty(hidden = true)
    private int limit;

    @ApiIgnore
    public int getOffset() {
        return (pageNumber - 1) * pageSize;
    }

    @ApiIgnore
    public int getLimit() {
        return pageSize;
    }
}
