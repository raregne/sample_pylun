package com.pylun.provider.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Provider
{
    @ApiModelProperty(required = true, notes = "소싱사 고유 번호", example = "1")
    private long providerIdx;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(required = true, notes = "소싱사명", example = "mcm")
    private String providerName;


    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(required = true, notes = "국가코드", example = "mcm")
    private String countryCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty(required = true, notes = "할인률", example = "50은 50%할인률")
    private BigDecimal rate;


}
