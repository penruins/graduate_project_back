package com.penruins.community.entity.dto;

import com.penruins.community.entity.PO.UserPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(value = "用户类", description = "前端传入的用户信息")
public class User2DTO {
  @NotEmpty(message = "姓名不能为空")
  @ApiModelProperty(notes = "姓名", example = "刘翔")
  private String username;

  @NotEmpty(message = "密码不能为空")
  @ApiModelProperty(notes = "密码", example = "mzrfviwhninayh")
  private String password;

}
