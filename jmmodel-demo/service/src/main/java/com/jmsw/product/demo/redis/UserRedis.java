/**
 * Copyright (c) 2018-2019 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 * 
 * Created on 2018年1月19日
 * Id: OrderRedis.java, 2018年1月19日 下午3:50:07 yehao
 */
package com.jmsw.product.demo.redis;

import com.jmsw.common.redis.RedisSupport;
import com.jmsw.product.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author yehao
 * @version 2.0
 * @date 2018年1月19日 下午3:50:07
 * @Description 用户redis写法示例
 */
@Service
public class UserRedis extends RedisSupport<User> {
	
	public void save(User user){
		redisTemplate.opsForValue().set(user.getId().toString(), user);
	}
	
	public User get(String id){
		return redisTemplate.opsForValue().get(id);
	}

}
