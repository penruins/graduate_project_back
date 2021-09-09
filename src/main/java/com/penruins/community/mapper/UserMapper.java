package com.penruins.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penruins.community.entity.PO.UserPO;
import org.apache.ibatis.annotations.Mapper;
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
public interface UserMapper extends BaseMapper<UserPO> {

}
