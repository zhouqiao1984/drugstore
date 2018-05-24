package com.drug.store.bean;

import java.math.BigDecimal;

/**
 * com.drug.store.pojo
 *
 * @desc 药品实体类
 * @author:xhl
 * @year: 2018
 * @month: 05
 * @day: 20
 * @time: 22:42
 */
public class Drug extends BaseBean {
    private int id;  //药品ID
	private String name;    //品名
    private BigDecimal price;   //价格
    private String description; //药品描述
    private int state;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Drug [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", state="
				+ state + "]";
	}
    
    
   
	
  	
  	

}
