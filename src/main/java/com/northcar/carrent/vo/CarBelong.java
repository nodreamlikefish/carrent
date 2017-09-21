package com.northcar.carrent.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CarBelong implements Serializable {
	private Integer id ;
	private String belonger ;
	private String belongType ;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBelonger() {
		return belonger;
	}

	public void setBelonger(String belonger) {
		this.belonger = belonger;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

	@Override
	public String toString() {
		return "CarBelong [id=" + id + ", belonger=" + belonger + ", belongType=" + belongType + "]";
	}
}
