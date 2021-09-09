package com.penruins.community.entity.common;

import com.penruins.community.entity.enums.IErrorInfo;
import com.penruins.community.utils.DateTimeUtils;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 通用接口返回对象
 *
 * References
 *  ~/Desktop/note/computer-science/project/QBlog2/qblog-server/src/main/java/pers/qianyucc/qblog/model/comm/Results.java
 *
 *
 */
@Data
/**
 * [lombok @Accessors用法](https://blog.csdn.net/weixin_38229356/article/details/82937420)
 * [@Accessors](https://projectlombok.org/features/experimental/Accessors)
 *
 * private Long id;
 * private String name;
 *
 * public User setId(Long id) {}
 * public User setName(String name) {}
 *
 */
@Accessors(chain = true)
@Builder
public class Results<T> {
  private int code;
  private String msg;
  private T data;
  private String timestamp;

  public static <T> Results<T> ok(T data) {
    return Results.<T>builder()
            .msg("操作成功")
            .data(data)
            .timestamp(DateTimeUtils.now())
            .build();
  }
  public static <T> Results<T> ok(String msg, T data) {
    return Results.<T>builder()
            .msg(msg)
            .data(data)
            .timestamp(DateTimeUtils.now())
            .build();

  }
  public static Results fromErrorInfo(IErrorInfo errorInfo) {
    return Results.builder()
            .code(errorInfo.getCode())
            .msg(errorInfo.getMsg())
            .timestamp(DateTimeUtils.now())
            .build();
  }
  public static <T> Results<T> error(T data) {
    return Results.<T>builder()
            .code(5000)
            .msg("操作失败")
            .data(data)
            .timestamp(DateTimeUtils.now())
            .build();
  }
  public static <T> Results<T> error(String msg, T data) {
    return Results.<T>builder()
            .code(5000)
            .msg(msg)
            .data(data)
            .timestamp(DateTimeUtils.now())
            .build();
  }
}
