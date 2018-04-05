package com.pylun.brand.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Brand
{
    @ApiModelProperty(required = true, notes = "브랜드 고유 번호", example = "1")
    private long brandIdx;


    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(required = true, notes = "할인률", example = "50은 50%할인률")
    private BigDecimal rate;

}
