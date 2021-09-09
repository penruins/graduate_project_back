package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.GasPO;
import com.penruins.community.entity.VO.finance.GasVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GasMapper extends BaseMapper<GasPO> {
  @Select("select * from gas_view")
  Page<GasVO> selectGasListViewPage(Page<GasVO> pagination);
}
