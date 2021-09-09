package com.penruins.community.controller;


import cn.hutool.core.map.MapUtil;
import com.penruins.community.entity.PO.UserPO;
import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.entity.common.Results;
import com.penruins.community.entity.dto.User2DTO;
import com.penruins.community.entity.dto.UserDTO;
import com.penruins.community.service.FinanceService;
import com.penruins.community.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author penruins
 * @since 2021-04-15
 */
@Api("与用户账号相关的api接口")
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/user/{id}")
  @ApiOperation("根据id查询用户")
  public Results<UserPO> getUser(@PathVariable String id) {
    return Results.ok(userService.findById(id));
  }

  @ApiOperation("批量获取用户")
  @GetMapping("/users")
  public Results<PageVO> getUsers(@ApiParam("页码")
                                    @RequestParam(required = false, defaultValue = "1") Integer page,
                                  @ApiParam("每页存放的记录数") @RequestParam(required = false, defaultValue = "5") Integer limit) {
    return Results.ok(userService.getUsers(page,limit));
  }

  @ApiOperation("批量获取用户2")
  @GetMapping("/users/{page}/{limit}")
  public Results<PageVO> getUsers2(@PathVariable Integer page,@PathVariable Integer limit) {
    return Results.ok(userService.getUsers(page,limit));
  }

  @ApiOperation("新增用户")
  @PostMapping("/auth/users")
  public Results<Map<String, Object>> insertUser(@ApiParam(name = "用户信息", value = "传入json格式", required = true)
                                                 @RequestBody @Valid UserDTO userDTO) {
    boolean isSuccess = userService.insertUser(userDTO);
    return Results.ok(MapUtil.of("isSuccess",isSuccess));
  }

  @PostMapping("/login")
  @ResponseBody
  public Results login(@RequestBody User2DTO user2DTO) {
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user2DTO.getUsername(), user2DTO.getPassword());
    try {
      subject.login(usernamePasswordToken);
      return Results.ok(MapUtil.of("isSuccess",true));
    } catch (AuthenticationException e) {
      return Results.ok(MapUtil.of("isSuccess",false));
    }
  }
  @ResponseBody
  @GetMapping("/logout")
  public Results logout() {
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return Results.ok(MapUtil.of("isSuccess",true));
  }

  @ApiOperation("根据id删除用户")
  @DeleteMapping("/auth/user/{id}")
  @ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "String", paramType = "path")
  public Results deleteUser(@PathVariable String id) {
    userService.deleteUser(id);
    return Results.ok("删除成功", null);

  }

  @PutMapping("/auth/user/{id}")
  @ApiOperation("修改用户")
  @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String", paramType = "path")
  public Results<Map<String, Object>> updateUser(@ApiParam(name = "要修改的用户信息", value = "传入json格式", required = true)
                                                 @RequestBody UserDTO userDTO, @PathVariable String id) {
    userService.updateUser(userDTO,id);
    return Results.ok("更新成功",MapUtil.of("id",id));

  }
}

