package com.penruins.community.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanceVO {
  private Long userId;
  private String username;
  private Double waterBalance;
  private Double electricityBalance;
  private Double gasBalance;
  private Double housingFundBalance;
}
