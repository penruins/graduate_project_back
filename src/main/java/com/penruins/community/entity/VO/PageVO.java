package com.penruins.community.entity.VO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageVO<T> {
  private List<T> records;
  private long total;
  private long size;
  private long current;
}
