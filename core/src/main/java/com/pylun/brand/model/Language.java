package com.pylun.brand.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Language
{
    @ApiModelProperty(required = true, notes = "브랜드 언어 고유 번호", example = "1")
    private long languageIdx;

    @ApiModelProperty(required = true, notes = "브랜드 고유 번호", example = "1")
    private long brandIdx;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(required = true, notes = "언어 코드", example = "kr")
    private String languageCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(required = true, notes = "브랜드명", example = "mcm")
    private String brandName;

}
