package com.penruins.community.service.finance;

import cn.hutool.core.util.IdUtil;
import com.penruins.community.entity.PO.HousingFundPO;
import com.penruins.community.mapper.HousingFundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingFundService {
  @Autowired
  private HousingFundMapper housingFundMapper;

  public boolean insertHousingFund(String userId) {
    HousingFundPO housingFundPO = new HousingFundPO();
    String id = IdUtil.objectId();
    housingFundPO.setId(id);
    housingFundPO.setUserId(userId);
    housingFundPO.setIsAble(0);
    housingFundMapper.insert(housingFundPO);
    return true;
  }
}
