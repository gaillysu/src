package com.toplion.entity;

/**
 * 产品对象
 * @author Ayres
 *
 */
public class Product {
private Integer imageOfpro;

public Integer getImageOfpro() {
	return imageOfpro;
}

public void setImageOfpro(Integer imageOfpro) {
	this.imageOfpro = imageOfpro;
}

public Product(Integer imageOfpro) {
	super();
	this.imageOfpro = imageOfpro;
}

public Product() {
	super();
	// TODO Auto-generated constructor stub
}

}
