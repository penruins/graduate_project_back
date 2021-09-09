package com.penruins.community.entity.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_gas")
public class GasPO implements Serializable {
  @TableId
  private String id;
  private String userId;
  private Double gasBalance;
  private Integer isAble;


  @TableLogic
  private Integer deleted;
}
