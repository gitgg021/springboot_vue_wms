package com.xuehua.wms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuehua.wms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wms
 * @since 2024-06-16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<User> myPage(Page<User> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<User> lambdaQueryWrapper);
}
