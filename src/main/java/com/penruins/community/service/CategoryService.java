package com.penruins.community.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.CategoryPO;
import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.entity.dto.CategoryDTO;
import com.penruins.community.entity.enums.ErrorInfoEnum;
import com.penruins.community.exception.CommunityException;
import com.penruins.community.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {
  @Autowired
  private CategoryMapper categoryMapper;

  public CategoryPO findById(String id) {
    CategoryPO category = categoryMapper.selectById(id);
    if(Objects.isNull(category)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    } else {
      return category;
    }
  }

  public PageVO<CategoryPO> getCategories(int page, int limit) {
    IPage<CategoryPO> categoryPage = new Page<>(page,limit);
    categoryPage = categoryMapper.selectPage(categoryPage,null);
    List<CategoryPO> categories = categoryPage.getRecords();
    PageVO<CategoryPO> pageVO = PageVO.<CategoryPO>builder()
            .records(categories.isEmpty() ? new ArrayList<>() : categories)
            .total(categoryPage.getTotal())
            .current(categoryPage.getCurrent())
            .size(categoryPage.getSize())
            .build();
    return pageVO;
  }
  public boolean insertCategory(CategoryDTO categoryDTO) {
    CategoryPO categoryPO = categoryDTO.toCategoryPO();
    categoryMapper.insert(categoryPO);
    return true;
  }
  public void updateCategory(CategoryDTO categoryDTO, String id) {
    CategoryPO categoryPO = categoryMapper.selectById(id);
    if(Objects.isNull(categoryPO)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    }
    CategoryPO categoryPO1 = categoryDTO.toCategoryPO();
    categoryPO1.setId(Long.valueOf(id));
    categoryMapper.updateById(categoryPO1);
  }
  public void deleteCategory(String id) {
    int i = categoryMapper.deleteById(id);
    if( i <= 0) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    }
  }
}
















