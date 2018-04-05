package com.pylun.member.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User
{
    @ApiModelProperty(notes = "고유 번호", example = "1")
    private long uIdx;
    @ApiModelProperty(notes = "업체 고유 번호", example = "2")
    private long comIdx;
    @ApiModelProperty(notes = "회원아이디", example = "abitree")
    private String uId;
    @ApiModelProperty(notes = "비밀번호", example = "abitreepw")
    private String uPassword;
    @ApiModelProperty(notes = "회원명", example = "abitree")
    private String uName;
    @ApiModelProperty(notes = "회원구분", example = "관리자")
    private String uType;
}
