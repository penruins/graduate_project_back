package com.penruins.community.service.finance;

import cn.hutool.core.util.IdUtil;
import com.penruins.community.entity.PO.WaterPO;
import com.penruins.community.entity.enums.ErrorInfoEnum;
import com.penruins.community.exception.CommunityException;
import com.penruins.community.mapper.WaterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WaterService {
  @Autowired
  private WaterMapper waterMapper;

  public boolean insertWater(String userId) {
    WaterPO waterPO = new WaterPO();
    String id = IdUtil.objectId();
    waterPO.setId(id);
    waterPO.setUserId(userId);
    waterPO.setWaterBalance(Double.valueOf(0));
    waterPO.setIsAble(0);
    waterMapper.insert(waterPO);
    return true;
  }
  public WaterPO findById(String id) {
    WaterPO waterPO = waterMapper.selectById(id);
    if(Objects.isNull(waterPO)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    } else {
      return waterPO;
    }
  }
}
