package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.ElectricityPO;
import com.penruins.community.entity.VO.finance.ElectricityVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ElectricityMapper extends BaseMapper<ElectricityPO> {
  @Select("select * from electricity_view")
  Page<ElectricityVO> selectElectricityListViewPage(Page<ElectricityVO> pagination);
}
