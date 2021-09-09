package com.penruins.community.exception;

import com.penruins.community.entity.common.Results;
import com.penruins.community.entity.enums.IErrorInfo;

public class CommunityException extends RuntimeException{
  public final IErrorInfo errorInfo;
  public CommunityException(IErrorInfo errorInfo) {
    this.errorInfo = errorInfo;
  }
  public Results toResultVO() {
    return Results.fromErrorInfo(errorInfo);
  }
}
