package com.xuehua.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuehua.wms.entity.User;
import com.xuehua.wms.mapper.UserMapper;
import com.xuehua.wms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wms
 * @since 2024-06-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public Page<User> myPage(Page<User> page, LambdaQueryWrapper<User> lambdaQueryWrapper) {
        return userMapper.myPage(page,lambdaQueryWrapper);
    }
}
