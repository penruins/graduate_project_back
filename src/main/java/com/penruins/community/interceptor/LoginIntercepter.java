package com.penruins.community.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    return false;
  }

  private boolean beginWith(String page, String[] requiredAuthPages) {
    boolean result = false;
    for(String requiredAuthPage : requiredAuthPages) {
      if(StringUtils.startsWith(page, requiredAuthPage)) {
        result = true;
        break;
      }
    }
    return result;
  }
}
