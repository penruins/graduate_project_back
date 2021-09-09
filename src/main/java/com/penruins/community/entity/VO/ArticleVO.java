package com.penruins.community.entity.VO;

import com.penruins.community.entity.PO.ArticlePO;
import com.penruins.community.utils.DateTimeUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {
  private Long id;
  private String author;
  private String title;
  private String category;
  private String tags;
  private String content;
  private String createTime;
  private String updateTime;


  public static ArticleVO fromArticlePO(ArticlePO articlePO) {
    return new Converter().convertToVO(articlePO);
  }


  private static class Converter implements IConverter<ArticlePO, ArticleVO> {

    @Override
    public ArticleVO convertToVO(ArticlePO articlePO) {
      final ArticleVO vo = new ArticleVO();
      vo.setId(articlePO.getId());
      vo.setAuthor(articlePO.getAuthor());
      vo.setTitle(articlePO.getTitle());
      vo.setCategory(String.valueOf(articlePO.getCategory()));
      vo.setContent(articlePO.getContent());
      vo.setCreateTime(DateTimeUtils.formatDatetime(articlePO.getCreateTime()));
      vo.setUpdateTime(DateTimeUtils.formatDatetime(articlePO.getUpdateTime()));
      return vo;
    }
  }
}

