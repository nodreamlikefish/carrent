package com.northcar.carrent.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RepairFactory implements Serializable {
	private Integer id ;
	private String repairFactory ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRepairFactory() {
		return repairFactory;
	}
	public void setRepairFactory(String repairFactory) {
		this.repairFactory = repairFactory;
	}
	@Override
	public String toString() {
		return "RepairFactory [id=" + id + ", repairFactory=" + repairFactory + "]";
	}
}
