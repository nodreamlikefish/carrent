package com.northcar.carrent.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FuelType implements Serializable {
	private Integer id ;
	private String fuel ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	@Override
	public String toString() {
		return "FuelType [id=" + id + ", fuel=" + fuel + "]";
	}
	
}
