package com.penruins.community.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.UserPO;
import com.penruins.community.entity.VO.PageVO;
import com.penruins.community.entity.dto.UserDTO;
import com.penruins.community.entity.enums.ErrorInfoEnum;
import com.penruins.community.exception.CommunityException;
import com.penruins.community.mapper.UserMapper;
import com.penruins.community.mapper.WaterMapper;
import com.penruins.community.service.finance.ElectricityService;
import com.penruins.community.service.finance.GasService;
import com.penruins.community.service.finance.HousingFundService;
import com.penruins.community.service.finance.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author penruins
 * @since 2021-04-15
 */
@Service
public class UserService {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private WaterService waterService;
  @Autowired
  private ElectricityService electricityService;
  @Autowired
  private GasService gasService;
  @Autowired
  private HousingFundService housingFundService;

  public UserPO findById(String id) {
    UserPO user = userMapper.selectById(id);
    if(Objects.isNull(user)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    } else {
      return user;
    }
  }
  public UserPO findByUsername(String username) {
    Map<String, Object> map = new HashMap<>();
    map.put("username",username);
    List<UserPO> list = userMapper.selectByMap(map);
    if(list.size() == 0) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    } else {
      return list.get(0);
    }
  }
  public boolean isExists(String username) {
    Map<String, Object> map = new HashMap<>();
    map.put("username",username);
    List<UserPO> list = userMapper.selectByMap(map);
    if(list.size() == 0) {
      return false;
    } else {
      return true;
    }
  }

  public PageVO<UserPO> getUsers(int page, int limit) {
    IPage<UserPO> userPage = new Page<>(page,limit);
    userPage = userMapper.selectPage(userPage,null);
    List<UserPO> users = userPage.getRecords();
    PageVO<UserPO> pageVO = PageVO.<UserPO>builder()
            .records(users.isEmpty() ? new ArrayList<>() : users)
            .total(userPage.getTotal())
            .current(userPage.getCurrent())
            .size(userPage.getSize())
            .build();
    return pageVO;
  }
  public boolean insertUser(UserDTO userDTO) {
    boolean exist = isExists(userDTO.getUsername());
    if(exist) {
      throw new CommunityException(ErrorInfoEnum.USERNAME_REPETITION);
    }
    UserPO user = userDTO.toUserPO();
    String id = IdUtil.objectId();
    user.setId(id);
    user.setIsAdministrator(0);
    user.setBalance(0L);
    user.setCreateTime(System.currentTimeMillis());
    user.setUpdateTime(System.currentTimeMillis());
    userMapper.insert(user);
    waterService.insertWater(id);
    electricityService.insertElectricity(id);
    gasService.insertGas(id);
    housingFundService.insertHousingFund(id);
    return true;
  }

  public void updateUser(UserDTO userDTO, String id) {
    UserPO userPO = userMapper.selectById(id);
    if(Objects.isNull(userPO)) {
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
    }
    UserPO userPO1 = userDTO.toUserPO();
    userPO1.setId(id);
    userMapper.updateById(userPO1);

  }
  public void deleteUser(String id) {
    int i = userMapper.deleteById(id);
    if( i <= 0)
      throw new CommunityException(ErrorInfoEnum.INVALID_ID);
  }
}
