package com.penruins.community.entity.PO;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author penruins
 * @since 2021-04-15
 */
@Data
@TableName(value = "t_user")
public class UserPO implements Serializable {

private static final long serialVersionUID=1L;

  @TableId
  private String id;

  private String id2;

  @TableField("isAdministrator")
  private Integer isAdministrator;

  private String username;

  private String password;

  private Long balance;

  private String telephone;

  private String address;

  private Long createTime;

  private Long updateTime;

  @TableLogic
  private Integer deleted;
}
