package com.salesmanager.shop.model.catalog.product.attribute;

import java.io.Serializable;

import com.salesmanager.shop.model.Entity;


public class ProductOptionValue extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
