package com.javabishe1234.vo;

import lombok.Data;

@Data
public class ProductModel {
	
	
	// 商品编号
	private String id;
	
	// 商品名称
	private String productTitle;
	
	// 商品分类名称
	private String brandName;
	
	// 价格
	private float price;
	
    // 销量
	private Integer sale;

	// 图片名称
	private String image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
