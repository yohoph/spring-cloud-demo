package com.jmsw.product.demo.service;

import com.jmsw.framework.core.cache.RedisTemplateBuilder;
import com.jmsw.product.demo.vo.DemoVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DemoServiceImpl implements DemoService {
	protected final Log logger = LogFactory.getLog(DemoServiceImpl.class);

    // RedisTemplate 含有泛型,无法使用 @Autowired by type 注入,只能使用@Resource by name注入
    @Autowired
    private RedisTemplateBuilder redisTemplateBuilder;

    //@Autowired
    //private ContentAuditService contentAuditService;

    @Override
    public void test() {
        //contentAuditService.testTransactional();
    }

    @Override
    public DemoVo persist(DemoVo demoVo) {
        logger.info("persist: " + demoVo);
        return demoVo;
    }

    @Override
    public DemoVo remove(Long id) {
        logger.info("remove: " + id);
        redisTemplateBuilder.buildRedisTemplate(DemoVo.class).delete(DemoService.cacheKey(id));
        return new DemoVo(id, "name", 18, new Date());
    }

    @Override
    public DemoVo merge(DemoVo demoVo) {
        logger.info("merge: " + demoVo);
        redisTemplateBuilder.buildRedisTemplate(DemoVo.class).opsForValue().set(DemoService.cacheKey(demoVo.getId()), demoVo);
        return demoVo;
    }

    @Override
    public DemoVo find(Long id) {
        logger.info("find: " + id);
        DemoVo cache = redisTemplateBuilder.buildRedisTemplate(DemoVo.class).opsForValue().get(DemoService.cacheKey(id));
        if (null != cache) {
            return cache;
        }
        DemoVo demoVo = new DemoVo(id, "name", 18, new Date());
        redisTemplateBuilder.buildRedisTemplate(DemoVo.class).opsForValue().set(DemoService.cacheKey(id), demoVo);
        return demoVo;
    }

    @Override
    public List<DemoVo> find(List<Long> ids) {
        List<DemoVo> demoVoList = new ArrayList<>();
        for (Long id : ids) {
            demoVoList.add(this.find(id));
        }
        return demoVoList;
    }

    @Override
    public List<DemoVo> find(DemoVo demoVo) {
        logger.info("find: " + demoVo);
        return Arrays.asList(new DemoVo(1001L, "name1", 18, new Date()),
                new DemoVo(1002L, "name2", 18, new Date()),
                new DemoVo(1003L, "name3", 18, new Date()));
    }

    @Override
    public List<DemoVo> find(Integer start, Integer limit) {
        List<DemoVo> list = new ArrayList<>();
        int end = start + limit;
        for (int i = start; i < end; i++) {
            list.add(new DemoVo(1000L + i, "name" + i, 18, new Date()));
        }
        return list;
    }

}
