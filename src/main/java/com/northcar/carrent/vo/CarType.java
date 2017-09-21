package com.northcar.carrent.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CarType implements Serializable {
	private Integer id ;
	private String carType ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	@Override
	public String toString() {
		return "CarType [id=" + id + ", carType=" + carType + "]";
	}
}
