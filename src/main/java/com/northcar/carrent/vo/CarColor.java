package com.northcar.carrent.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CarColor implements Serializable {
	private Integer id ;
	private String color ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "CarColor [id=" + id + ", color=" + color + "]";
	}
	
}
