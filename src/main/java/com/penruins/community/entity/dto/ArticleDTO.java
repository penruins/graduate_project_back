package com.penruins.community.entity.dto;

import com.penruins.community.entity.PO.ArticlePO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "文章类", description = "前端传入的文章信息")
public class ArticleDTO {
  private String author;
  private String title;
  private Long category;
  private String content;

  public ArticlePO toArticlePO() {
    ArticlePO articlePO = new ArticlePO();
    articlePO.setAuthor(this.author);
    articlePO.setTitle(this.title);
    articlePO.setCategory(this.category);
    articlePO.setContent(this.content);
    return articlePO;
  }
}
