package com.penruins.community.controller.finance;

import cn.hutool.core.map.MapUtil;
import com.penruins.community.entity.common.Results;
import com.penruins.community.service.finance.WaterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("与水费相关的api接口")
@RestController
@RequestMapping("/water")
public class WaterController {

  @Autowired
  private WaterService waterService;

  @ApiOperation("新增水费记录")
  @PostMapping("/auth/water/{id}")
  public Results<Map<String, Object>> insertWater(@PathVariable String id) {
    boolean isSuccess = waterService.insertWater(id);
    return Results.ok(MapUtil.of("isSuccess",isSuccess));
  }
}
