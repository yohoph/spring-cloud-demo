package com.jmsw.product.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品信息
 */
@ApiModel("商品信息")
public class Product {
    @ApiModelProperty(value="商品ID")
    private Long id;
    @ApiModelProperty(value="商品分类")
    private Long categoryId;
    @ApiModelProperty(value="商品名称")
    private String name;
    @ApiModelProperty(value="商品描述")
    private String description;
    @ApiModelProperty(value="商品图片地址")
    private String imageurl;

    public Product() {
    }

    public Product(Long id, Long categoryId, String name, String description, String imageurl) {
        this();
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageurl='" + imageurl + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
