package com.penruins.community.controller;

import cn.hutool.core.map.MapUtil;
import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.entity.common.Results;
import com.penruins.community.entity.dto.CategoryDTO;
import com.penruins.community.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Api("与文章类别相关的api接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @ApiOperation("批量获取文章类别")
  @GetMapping("/categories")
  public Results<PageVO> getCategories(@ApiParam("页码") @RequestParam(required = false, defaultValue = "1") Integer page,
                                     @ApiParam("每页存放的记录数") @RequestParam(required = false, defaultValue = "5") Integer limit) {
    return Results.ok(categoryService.getCategories(page,limit));
  }

  @ApiOperation("批量获取文章类别2")
  @GetMapping("/categories/{page}/{limit}")
  public Results<PageVO> getCategories2(@PathVariable Integer page,@PathVariable Integer limit) {
    return Results.ok(categoryService.getCategories(page,limit));
  }

  @ApiOperation("根据id删除文章分类")
  @DeleteMapping("/auth/category/{id}")
  @ApiImplicitParam(name = "id", value = "category id", required = true, dataType = "String", paramType = "path")
  public Results deleteCategory(@PathVariable String id) {
    categoryService.deleteCategory(id);
    return Results.ok("删除成功", null);
  }

  @ApiOperation("修改文章分类")
  @PutMapping("/auth/category/{id}")
  @ApiImplicitParam(name = "id", value = "category id", required = true, dataType = "String", paramType = "path")
  public Results<Map<String, Object>> updateCategory(@ApiParam(name = "要修改的文章分类信息", value = "传入json格式", required = true)
                                                     @RequestBody CategoryDTO categoryDTO, @PathVariable String id) {
    categoryService.updateCategory(categoryDTO,id);
    return Results.ok("更新成功", MapUtil.of("id",id));
  }
  @ApiOperation("新增文章分类")
  @PostMapping("auth/category")
  public Results<Map<String, Object>> insertCategory(@ApiParam(name = "文章分类信息", value = "传入json格式", required = true)
                                                     @RequestBody @Valid CategoryDTO categoryDTO) {
    boolean isSuccess = categoryService.insertCategory(categoryDTO);
    return Results.ok(MapUtil.of("isSuccess", isSuccess));
  }



}






