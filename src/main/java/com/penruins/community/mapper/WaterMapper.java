package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.entity.PO.WaterPO;
import com.penruins.community.entity.VO.finance.WaterVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author penruins
 * @since 2021-04-15
 */
@Mapper
@Repository
public interface WaterMapper extends BaseMapper<WaterPO> {
  @Select("select * from water_view")
  Page<WaterVO> selectWaterListViewPage(Page<WaterVO> pagination);
}
