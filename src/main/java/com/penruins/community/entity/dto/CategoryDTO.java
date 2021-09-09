package com.penruins.community.entity.dto;


import com.penruins.community.entity.PO.CategoryPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(value = "文章类别类", description = "前端传入的文章类别信息")
public class CategoryDTO {
  @NotEmpty(message = "文章类别的名称不能为空")
  @ApiModelProperty(notes = "文章类别的名称", example = "时事新闻")
  private String name;

  public CategoryPO toCategoryPO() {
    CategoryPO categoryPO = new CategoryPO();
    categoryPO.setName(this.name);
    return categoryPO;
  }
}
