package com.penruins.community.controller;


import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.entity.common.Results;
import com.penruins.community.service.FinanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("与财务信息相关的api接口")
@RestController
@RequestMapping("/finance")
public class FinanceController {
  @Autowired
  private FinanceService financeService;

  @ApiOperation("批量获取财务信息")
  @GetMapping("/finances/{page}/{limit}")
  public Results<PageVO> getFinances(@PathVariable Integer page, @PathVariable Integer limit) {
    return Results.ok(financeService.getFinances(page, limit));
  }

}
