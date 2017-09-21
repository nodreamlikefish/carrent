package com.northcar.carrent.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CarOwner implements Serializable {
	private Integer id ;
	private String owner ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "CarOwner [id=" + id + ", owner=" + owner + "]";
	}
}
