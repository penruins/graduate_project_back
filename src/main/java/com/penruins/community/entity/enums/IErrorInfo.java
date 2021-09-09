package com.penruins.community.entity.enums;

public interface IErrorInfo {
  /**
   * 获取错误信息
   * @return
   */
  String getMsg();

  /**
   * 获取错误码
   * @return
   */
  int getCode();
}
