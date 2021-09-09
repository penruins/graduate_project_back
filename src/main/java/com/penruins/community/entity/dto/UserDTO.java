package com.penruins.community.entity.dto;

import com.penruins.community.entity.PO.UserPO;
import com.penruins.community.utils.DateTimeUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(value = "用户类", description = "前端传入的用户信息")
public class UserDTO {
  @NotEmpty(message = "身份证号码不能为空")
  @ApiModelProperty(notes = "用户身份证号码", example = "530102199807240711")
  private String id2;

  @NotEmpty(message = "姓名不能为空")
  @ApiModelProperty(notes = "姓名", example = "刘翔")
  private String username;

  @NotEmpty(message = "密码不能为空")
  @ApiModelProperty(notes = "密码", example = "mzrfviwhninayh")
  private String password;

  @NotEmpty(message = "电话号码不能为空")
  @ApiModelProperty(notes = "电话号码", example = "17356582393")
  private String telephone;

  @NotEmpty(message = "地址不能为空")
  @ApiModelProperty(notes = "地址", example = "云南省昆明市西山区碧鸡名城2幢707")
  private String address;

  public UserPO toUserPO() {
    UserPO user = new UserPO();
    user.setId2(this.id2);
    user.setUsername(this.username);
    user.setPassword(this.password);
    user.setTelephone(this.telephone);
    user.setAddress(this.address);
    return user;
  }
}
