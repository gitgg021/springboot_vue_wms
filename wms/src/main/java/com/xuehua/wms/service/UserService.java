package com.xuehua.wms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuehua.wms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wms
 * @since 2024-06-16
 */
public interface UserService extends IService<User> {

    Page<User> myPage(Page<User> page,LambdaQueryWrapper<User> lambdaQueryWrapper);
}
