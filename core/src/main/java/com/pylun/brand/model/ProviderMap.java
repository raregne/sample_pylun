package com.pylun.brand.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderMap
{
    @ApiModelProperty(required = true, notes = "브랜드 소싱사 공유 번호", example = "1")
    private long providerMapIdx;

    @ApiModelProperty(required = true, notes = "브랜드 고유 번호", example = "1")
    private long brandIdx;

    @ApiModelProperty(required = true, notes = "소싱사 고유 번호", example = "1")
    private long providerIdx;
}
