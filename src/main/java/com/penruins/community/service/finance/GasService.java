package com.penruins.community.service.finance;

import cn.hutool.core.util.IdUtil;
import com.penruins.community.entity.PO.GasPO;
import com.penruins.community.entity.enums.ErrorInfoEnum;
import com.penruins.community.exception.CommunityException;
import com.penruins.community.mapper.GasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GasService {
  @Autowired
  private GasMapper gasMapper;

  public boolean insertGas(String userId) {
    GasPO gasPO = new GasPO();
    String id = IdUtil.objectId();
    gasPO.setId(id);
    gasPO.setUserId(userId);
    gasPO.setGasBalance(Double.valueOf(0));
    gasPO.setIsAble(0);
    gasMapper.insert(gasPO);
    return true;
  }

  public GasPO findById(String id) {
    GasPO gasPO = gasMapper.selectById(id);
    if(Objects.isNull(gasPO)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    } else {
      return gasPO;
    }
  }
}
