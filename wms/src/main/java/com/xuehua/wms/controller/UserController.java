package com.xuehua.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuehua.wms.common.QueryPageParam;
import com.xuehua.wms.common.Result;
import com.xuehua.wms.entity.User;
import com.xuehua.wms.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wms
 * @since 2024-06-16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //新增
    @PostMapping("/save")
    public Boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    //修改
    @PostMapping("/mod")
    public Boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public Boolean saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    //删除
    @GetMapping("/delete")
    public Boolean delete(Integer id) {
        return userService.removeById(id);
    }

    //查询(模糊,匹配)
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, user.getName());
        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
    //public List<User> listPage(@RequestBody HashMap map) {
    public List<User> listPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,param.get("name"));

        Page<User> result = userService.page(page, lambdaQueryWrapper);

        System.out.println("total = "+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listMyPage")
    //public List<User> listPage(@RequestBody HashMap map) {
    public List<User> listMyPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,param.get("name"));

        Page<User> result = userService.myPage(page,lambdaQueryWrapper);

        System.out.println("total = "+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listMyPage1")
    //public List<User> listPage(@RequestBody HashMap map) {
    public Result listMyPage1(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,param.get("name"));

        Page<User> result = userService.myPage(page,lambdaQueryWrapper);

        System.out.println("total = "+result.getTotal());

        return Result.succeed(result.getRecords(),result.getTotal());
    }

}
