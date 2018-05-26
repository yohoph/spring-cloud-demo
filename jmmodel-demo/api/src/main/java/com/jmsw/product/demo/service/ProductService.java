package com.jmsw.product.demo.service;

import com.jmsw.common.response.PageList;
import com.jmsw.framework.core.vo.Response;
import com.jmsw.product.demo.entity.Product;

public interface ProductService {
    Response<PageList<Product>> selectAll(Integer pageNum, Integer pageSize, Long total);

    Response<Product> selectById(Long id);

    Response<Integer> insert(Product product);

    Response<Integer> delete(Long id);

    Response<Integer> update(Product product);
}
