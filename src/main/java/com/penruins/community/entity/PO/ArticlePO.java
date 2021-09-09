package com.penruins.community.entity.PO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "t_article")
public class ArticlePO implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "id")
  private Long id;

  private String author;
  private String title;
  private Long category;
  private String tags;
  private String content;
  private Long createTime;
  private Long updateTime;

  @TableLogic
  private Integer deleted;
}
