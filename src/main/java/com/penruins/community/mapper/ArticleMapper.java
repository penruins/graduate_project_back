package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.ArticlePO;
import com.penruins.community.entity.VO.ArticleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<ArticlePO> {
  @Select("select * from article_view")
  Page<ArticleVO> selectArticleListViewPage(Page<ArticleVO> pagination);
}
