package com.penruins.community.entity.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_finance")
public class FinancePO implements Serializable {
  @TableId
  private String id;
  private String userId;
  private String waterId;
  private String electricityId;
  private String gasId;
  private String housingFundId;


  @TableLogic
  private Integer deleted;
}
