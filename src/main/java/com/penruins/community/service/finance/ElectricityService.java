package com.penruins.community.service.finance;

import cn.hutool.core.util.IdUtil;
import com.penruins.community.entity.PO.ElectricityPO;
import com.penruins.community.entity.enums.ErrorInfoEnum;
import com.penruins.community.exception.CommunityException;
import com.penruins.community.mapper.ElectricityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ElectricityService {
  @Autowired
  private ElectricityMapper electricityMapper;

  public boolean insertElectricity(String userId) {
    ElectricityPO electricityPO = new ElectricityPO();
    String id = IdUtil.objectId();
    electricityPO.setId(id);
    electricityPO.setUserId(userId);
    electricityPO.setElectricityBalance(Double.valueOf(0));
    electricityPO.setIsAble(0);
    electricityMapper.insert(electricityPO);
    return true;
  }
  public ElectricityPO findById(String id) {
    ElectricityPO electricityPO = electricityMapper.selectById(id);
    if(Objects.isNull(electricityPO)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    } else {
      return electricityPO;
    }
  }
}
