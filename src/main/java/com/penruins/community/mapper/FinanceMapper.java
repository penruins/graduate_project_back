package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.FinancePO;
import com.penruins.community.entity.VO.finance.FinanceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FinanceMapper extends BaseMapper<FinancePO> {


  @Select("select t_finance.user_id, t_user.username, t_water.water_balance, t_electricity.electricity_balance, t_gas.gas_balance, t_housing_fund.housing_fund_balance from t_finance " +
          "join t_user on t_finance.user_id = t_user.id " +
          "join t_water on t_finance.water_id = t_water.id " +
          "join t_electricity on t_finance.electricity_id = t_electricity.id " +
          "join t_gas on t_finance.gas_id = t_gas.id " +
          "join t_housing_fund on t_finance.housing_fund_id = t_housing_fund.id")
  Page<com.penruins.community.entity.VO.FinanceVO> selectFinanceListPage(Page<com.penruins.community.entity.VO.FinanceVO> pagination);
  @Select("select * from finance_view")
  Page<FinanceVO> selectFinanceListViewPage(Page<FinanceVO> pagination);
}
