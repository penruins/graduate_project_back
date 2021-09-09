package com.penruins.community.controller;

import cn.hutool.core.map.MapUtil;
import com.penruins.community.entity.PO.ArticlePO;
import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.entity.common.Results;
import com.penruins.community.entity.dto.ArticleDTO;
import com.penruins.community.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Api("与文章相关的api接口")
@RestController
@RequestMapping("/article")
public class ArticleController {
  @Autowired
  private ArticleService articleService;

  @GetMapping("/article/{id}")
  @ApiOperation(("根据id查询文章"))
  public Results<ArticlePO> getArticle(@PathVariable String id) {
    return Results.ok(articleService.findById(id));
  }

  /*
  @ApiOperation("批量获取文章")
  @GetMapping("/articles")
  public Results<PageVO> getArticles(@ApiParam("页码") @RequestParam(required = false, defaultValue = "1") Integer page,
                                     @ApiParam("每页存放的记录数") @RequestParam(required = false, defaultValue = "5") Integer limit) {
    return Results.ok(articleService.getArticles(page,limit));
  }
   */

  @ApiOperation("批量获取文章")
  @GetMapping("/articles/{page}/{limit}")
  public Results<PageVO> getArticles(@PathVariable Integer page,@PathVariable Integer limit) {
    return Results.ok(articleService.getArticles(page,limit));
  }

  @ApiOperation("新增文章")
  @PostMapping("/auth/articles")
  public Results<Map<String, Object>> insertArticle(@ApiParam(name = "文章信息", value = "传入json格式", required = true)
                                                    @RequestBody @Valid ArticleDTO articleDTO) {
    String id = articleService.insertArticle(articleDTO);
    return Results.ok(MapUtil.of("id",id));
  }
  @ApiOperation("根据id删除文章")
  @DeleteMapping("/auth/article/{id}")
  @ApiImplicitParam(name = "id", value = "article id", required = true, dataType = "String", paramType = "path")
  public Results deleteArticle(@PathVariable String id) {
    articleService.deleteArticle(id);
    return Results.ok("删除成功", null);
  }

  @ApiOperation("修改文章")
  @PutMapping("/auth/article/{id}")
  @ApiImplicitParam(name = "id", value = "文章id", required = true, dataType = "String", paramType = "path")
  public Results<Map<String, Object>> updateUser(@ApiParam(name = "要修改的用户信息", value = "传入json格式", required = true)
                                                 @RequestBody ArticlePO article, @PathVariable String id) {
    articleService.updateArticle(article,id);
    return Results.ok("更新成功", MapUtil.of("id", id));
  }
}
