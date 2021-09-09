package com.penruins.community.controller.finance;

import cn.hutool.core.map.MapUtil;
import com.penruins.community.entity.common.Results;
import com.penruins.community.service.finance.HousingFundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("与住房公积金有关的api接口")
@RestController
@RequestMapping("/housingfund")
public class HousingFundController {
  @Autowired
  private HousingFundService housingFundService;

  @ApiOperation("新增住房公积金记录")
  @PostMapping("/auth/housingfund/{id}")
  public Results<Map<String, Object>> insertHousingFund(@PathVariable String id) {
    boolean isSuccess = housingFundService.insertHousingFund(id);
    return Results.ok(MapUtil.of("isSuccess", isSuccess));
  }
}
