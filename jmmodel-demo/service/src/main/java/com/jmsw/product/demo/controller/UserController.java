package com.jmsw.product.demo.controller;

import com.jmsw.framework.core.vo.Response;
import com.jmsw.framework.core.vo.ResponseUtils;
import com.jmsw.product.demo.ApplicationDemoService;
import com.jmsw.product.demo.entity.User;
import com.jmsw.product.demo.redis.UserRedis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/23 17:06
 * @Description 用户管理demo演示，主要使用redis的API
 */
@Api(tags = "用户管理 ")
@RestController
@RequestMapping("services/app")
public class UserController {

    @Autowired
    private UserRedis userRedis;

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    @ApiOperation("查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", paramType = "path", allowableValues = ApplicationDemoService.COMPATIBLE_VERSION, required = true),
            @ApiImplicitParam(name = "token", paramType = "header", required = false)
    })
    @GetMapping("/{version}/user/getUser")
    public Response<User> getUser(Integer userId){
        if(userId != null){
            User user = userRedis.get(userId.toString());
            return ResponseUtils.returnApiObjectSuccess(user);
        }
        return null;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @ApiOperation("更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", paramType = "path", allowableValues = ApplicationDemoService.COMPATIBLE_VERSION, required = true),
            @ApiImplicitParam(name = "token", paramType = "header", required = false)
    })
    @PostMapping("/{version}/user/updateUser")
    public Response<Integer> updateUser(User user){
        if(user != null && user.getId() != null){
            userRedis.save(user);
        }
        return ResponseUtils.returnApiObjectSuccess(1);
    }


}
