package com.penruins.community.controller.finance;

import cn.hutool.core.map.MapUtil;
import com.penruins.community.entity.common.Results;
import com.penruins.community.service.finance.GasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("与气费有关的api接口")
@RestController
@RequestMapping("/gas")
public class GasController {
  @Autowired
  private GasService gasService;

  @ApiOperation("新增气费记录")
  @PostMapping("/auth/gas/{id}")
  public Results<Map<String, Object>> insertGas(@PathVariable String id) {
    boolean isSuccess = gasService.insertGas(id);
    return Results.ok(MapUtil.of("isSuccess",isSuccess));
  }
}
