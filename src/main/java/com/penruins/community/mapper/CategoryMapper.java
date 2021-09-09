package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penruins.community.entity.PO.CategoryPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<CategoryPO> {

}
