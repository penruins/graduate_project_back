package com.penruins.community.controller.finance;

import cn.hutool.core.map.MapUtil;
import com.penruins.community.entity.common.Results;
import com.penruins.community.service.finance.ElectricityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("与电费有关的api接口")
@RestController
@RequestMapping("/electricity")
public class ElectricityController {
  @Autowired
  private ElectricityService electricityService;

  @ApiOperation("新增电费记录")
  @PostMapping("/auth/electricity/{id}")
  public Results<Map<String, Object>> insertElectricity(@PathVariable String id) {
    boolean isSuccess = electricityService.insertElectricity(id);

    return Results.ok(MapUtil.of("isSuccess", isSuccess));
  }
}
