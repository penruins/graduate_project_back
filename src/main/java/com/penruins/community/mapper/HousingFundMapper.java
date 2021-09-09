package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.HousingFundPO;
import com.penruins.community.entity.VO.finance.HousingFundVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HousingFundMapper extends BaseMapper<HousingFundPO> {
  @Select("select * from housing_fund_view")
  Page<HousingFundVO> selectHousingFundListViewPage(Page<HousingFundVO> pagination);
}
