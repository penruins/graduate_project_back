package com.penruins.community.controller;


import com.penruins.community.entity.common.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("通用接口")
@RestController
public class CommonController {
  @ApiOperation("检查服务端是否正常")
  @GetMapping("/ping")
  public Results ping() {
    return Results.ok("欢迎访问 community API", null);
  }
  @ApiOperation("检查服务端是否正常")
  @GetMapping("/ping2")
  public String ping2() {
    //return Results.ok("欢迎访问 community API", null);
    return "hello";
  }

}
