package com.penruins.community.global;

import com.penruins.community.entity.common.Results;
import com.penruins.community.exception.CommunityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptioinHandler {
  @ResponseBody
  @ExceptionHandler(value = CommunityException.class)
  @ResponseStatus(HttpStatus.OK)
  public Results blogExceptionHandler(CommunityException exception) {
    log.error("BlogException:{}", exception.errorInfo.getMsg());
    return exception.toResultVO();
  }
}
