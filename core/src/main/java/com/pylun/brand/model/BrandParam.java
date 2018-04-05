package com.pylun.brand.model;

import com.pylun.service.common.model.Pager;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandParam extends Pager
{
    @ApiModelProperty(notes = "브랜드 고유 번호", example = "1")
    private long brandIdx;
}
