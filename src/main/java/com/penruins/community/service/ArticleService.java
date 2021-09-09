package com.penruins.community.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.ArticlePO;
import com.penruins.community.entity.VO.ArticleVO;
import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.entity.dto.ArticleDTO;
import com.penruins.community.entity.enums.ErrorInfoEnum;
import com.penruins.community.exception.CommunityException;
import com.penruins.community.mapper.ArticleMapper;
import com.penruins.community.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleService {
  @Autowired
  private ArticleMapper articleMapper;

  public ArticlePO findById(String id) {
    ArticlePO article = articleMapper.selectById(id);
    if(Objects.isNull(article)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    } else {
      return article;
    }
  }

  /*
  public PageVO<ArticleVO> getArticles(int page, int limit) {
    QueryWrapper<ArticlePO> qw = new QueryWrapper<>();
    qw.select(ArticlePO.class, i -> !"content".equals(i.getColumn()));
    Page<ArticlePO> res = articleMapper.selectPage(new Page<>(page,limit), qw);
    List<ArticleVO> articleVOS = res.getRecords().stream()
            .map(ArticleVO::fromArticlePO)
            .collect(Collectors.toList());
    PageVO<ArticleVO> pageVO = PageVO.<ArticleVO>builder()
            .records(articleVOS.isEmpty() ? new ArrayList<>() : articleVOS)
            .total(res.getTotal())
            .current(res.getCurrent())
            .size(res.getSize())
            .build();
    return pageVO;
  }
  */

  public PageVO<ArticleVO> getArticles(int page, int limit) {
    Page<ArticleVO> res = articleMapper.selectArticleListViewPage(new Page<>(page,limit));
    List<ArticleVO> list = res.getRecords();
    for(ArticleVO article : list) {
      article.setCreateTime(DateTimeUtils.formatDatetime(Long.valueOf(article.getCreateTime())));
      article.setUpdateTime(DateTimeUtils.formatDatetime(Long.valueOf(article.getUpdateTime())));

    }
    PageVO<ArticleVO> pageVO = PageVO.<ArticleVO>builder()
            .records(res.getRecords())
            .total(res.getTotal())
            .current(res.getCurrent())
            .size(res.getSize())
            .build();
    return pageVO;
  }
  public String insertArticle(ArticleDTO articleDTO) {
    ArticlePO articlePO = articleDTO.toArticlePO();
    articlePO.setCreateTime(System.currentTimeMillis());
    articlePO.setUpdateTime(System.currentTimeMillis());
    articlePO.setTags("");
    articleMapper.insert(articlePO);
    return String.valueOf(articlePO.getId());
  }

  public void updateArticle(ArticlePO article, String id) {
    ArticlePO a = articleMapper.selectById(id);
    if(Objects.isNull(a)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    }
    articleMapper.updateById(article);
  }
  public void deleteArticle(String id) {
    int i = articleMapper.deleteById(id);
    if( i <= 0)
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
  }
}
















