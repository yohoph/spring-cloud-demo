package com.jmsw.product.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jmsw.common.response.PageList;
import com.jmsw.common.utils.GsonUtils;
import com.jmsw.framework.core.vo.Response;
import com.jmsw.framework.core.vo.ResponseUtils;
import com.jmsw.product.demo.dao.ProductDao;
import com.jmsw.product.demo.entity.Product;
import com.jmsw.product.demob.api.OrderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderApi orderApi;

    @Override
    public Response<PageList<Product>> selectAll(Integer pageNum, Integer pageSize, Long total) {
        // count优化 APP 请求不需要count; 管理系统条件没有改变的情况下不用重复查询count,第一次请求total传-1,第二次请求将total带上来;
        boolean isNeedCount = total < 0;

        Page<Product> page = PageHelper.startPage(pageNum, pageSize, isNeedCount);

        PageList<Product> pageList = new PageList<>();
        pageList.setCurrentPage(pageNum);
        pageList.setPageSize(pageSize);
        if (isNeedCount) {
            pageList.setCount(page.getTotal());
        } else {
            pageList.setCount(total);
        }

        pageList.setEntities(productDao.selectAll());

        return ResponseUtils.returnObjectSuccess(pageList);
    }

    @Override
    public Response<Product> selectById(Long id) {
        System.out.println(GsonUtils.parseJson(orderApi.getOrder("100")));
        return ResponseUtils.returnObjectSuccess(productDao.selectById(id));
    }

    @Override
    @Transactional
    public Response<Integer> insert(Product product) {
        return ResponseUtils.returnObjectSuccess(productDao.insert(product));
    }

    @Override
    @Transactional
    public Response<Integer> delete(Long id) {
        int result = productDao.delete(id);
        if (id % 2 == 0) {
            throw new RuntimeException("事务回滚");
        }
        return ResponseUtils.returnObjectSuccess(result);
    }

    @Override
    @Transactional
    public Response<Integer> update(Product product) {
        return ResponseUtils.returnObjectSuccess(productDao.update(product));
    }
}
