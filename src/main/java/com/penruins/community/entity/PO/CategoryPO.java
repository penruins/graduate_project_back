package com.penruins.community.entity.PO;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_category")
public class CategoryPO implements Serializable {
  private Long id;
  private String name;


  @TableLogic
  private Integer deleted;
}
