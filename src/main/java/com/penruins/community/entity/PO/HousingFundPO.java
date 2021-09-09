package com.penruins.community.entity.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "t_housing_fund")
public class HousingFundPO {
  @TableId
  private String id;
  private String userId;
  private Date openDate;
  private Double housingFundBalance;
  private Double basenumber;
  private Double unitprop;
  private Double perprop;
  private Integer isAble;


  @TableLogic
  private Integer deleted;
}
