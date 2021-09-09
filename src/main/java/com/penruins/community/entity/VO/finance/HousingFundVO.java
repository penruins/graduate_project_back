package com.penruins.community.entity.VO.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HousingFundVO {
  private Long id;
  private String username;
  private Double housingFundBalance;
}
