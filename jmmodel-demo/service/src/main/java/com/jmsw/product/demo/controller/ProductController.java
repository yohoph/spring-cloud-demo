package com.jmsw.product.demo.controller;

import com.jmsw.common.response.PageList;
import com.jmsw.framework.core.vo.Response;
import com.jmsw.framework.core.vo.ResponseUtils;
import com.jmsw.product.demo.ApplicationDemoService;
import com.jmsw.product.demo.entity.Product;
import com.jmsw.product.demo.entity.User;
import com.jmsw.product.demo.redis.UserRedis;
import com.jmsw.product.demo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yehao
 * @version 1.0
 * @date 2018/5/22 15:39
 * @Description CRUD示例
 */
@Api(tags = "商品管理 ")
@RestController
@RequestMapping("services/app")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRedis userRedis;

    @Value("${demo-key}")
    String demoKey;

    @Value("${demo-key1}")
    String demoKey1;

    /**
     * 查询商品列表
     * @param pageNum
     * @param pageSize
     * @param total
     * @return
     */
    @ApiOperation("查询商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", paramType = "path", allowableValues = ApplicationDemoService.COMPATIBLE_VERSION, required = true),
            @ApiImplicitParam(name = "token", paramType = "header", required = false)
    })
    @GetMapping("/{version}/product/selectAll")
    public Response<PageList<Product>> selectAll(Integer pageNum, Integer pageSize, Long total){
        pageNum =  pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        total = total == null ? -1L : total;
        return productService.selectAll(pageNum,pageSize,total);
    }

    /**
     * 查询商品信息
     * @param id
     * @return
     */
    @ApiOperation("查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", paramType = "path", allowableValues = ApplicationDemoService.COMPATIBLE_VERSION, required = true),
            @ApiImplicitParam(name = "token", paramType = "header", required = false)
    })
    @GetMapping("/{version}/product/selectById")
    public Response<Product> selectById(Long id){
        return productService.selectById(id);
    }

    /**
     * 添加商品
     * @return
     */
    @ApiOperation("添加商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", paramType = "path", allowableValues = ApplicationDemoService.COMPATIBLE_VERSION, required = true),
            @ApiImplicitParam(name = "token", paramType = "header", required = false)
    })
    @PostMapping("/{version}/product/insert")
    public Response<Integer> insert(){
        Product product = new Product();
        product.setCategoryId(1001L);
        product.setDescription("yehao-description");
        product.setImageurl("imageurl-1");
        product.setName("yehao-name-1");
        return productService.insert(product);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @ApiOperation("删除商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", paramType = "path", allowableValues = ApplicationDemoService.COMPATIBLE_VERSION, required = true),
            @ApiImplicitParam(name = "token", paramType = "header", required = false)
    })
    @PostMapping("/{version}/product/delete")
    public Response<Integer> delete(Long id){
        return productService.delete(id);
    }

    /**
     * 更新商品
     * @param product
     * @return
     */
    @ApiOperation("更新商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", paramType = "path", allowableValues = ApplicationDemoService.COMPATIBLE_VERSION, required = true),
            @ApiImplicitParam(name = "token", paramType = "header", required = false)
    })
    @PostMapping("/{version}/product/update")
    public Response<Integer> update(Product product){
        product.setId(13L);
        product.setName("yehao-test-name");
        return productService.update(product);
    }

    @RequestMapping("getDemoKey")
    public Response<String> getDemoKey(){
        return ResponseUtils.returnApiObjectSuccess(demoKey + "--" + demoKey1);
    }



}
