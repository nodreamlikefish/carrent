package com.northcar.carrent.vo.carManage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class CarInfo implements Serializable {
	//车辆编号
	private Integer carId ;
	//车牌号
	private String plateNo ;
	//发动机号
	private String engineNo ;
	//车型
	private String carType ;
	//车架号  
	private String carJiaNo ;
	//车主  
	private String carOwner ;
	//产权归属 
	private String carBelong ;
	//车辆颜色
	private String color ;
	//燃油类型
	private String fuelType ;
	//购置日期
	private Date buyDate ;
	//经销商
	private String seller ;
	//车款
	private BigDecimal carMoney ;
	//购置税
	private BigDecimal buyTax ;
	//全车款
	private BigDecimal allMoney ;
	//折旧期
	private Integer zheJiuMonth ;
	//折旧率
	private Double zheJiuPercent ;
	//月折旧额
	private BigDecimal zheJiuFeePerMon ;
	//是否处理
	private String isDeal ;
	//下次验车日期
	private Date nextYancheDate ;
	//备注
	private String memo ;
	//车辆状态
	private String status ;
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarJiaNo() {
		return carJiaNo;
	}
	public void setCarJiaNo(String carJiaNo) {
		this.carJiaNo = carJiaNo;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getCarBelong() {
		return carBelong;
	}
	public void setCarBelong(String carBelong) {
		this.carBelong = carBelong;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public BigDecimal getCarMoney() {
		return carMoney;
	}
	public void setCarMoney(BigDecimal carMoney) {
		this.carMoney = carMoney;
	}
	public BigDecimal getBuyTax() {
		return buyTax;
	}
	public void setBuyTax(BigDecimal buyTax) {
		this.buyTax = buyTax;
	}
	public BigDecimal getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(BigDecimal allMoney) {
		this.allMoney = allMoney;
	}
	public Integer getZheJiuMonth() {
		return zheJiuMonth;
	}
	public void setZheJiuMonth(Integer zheJiuMonth) {
		this.zheJiuMonth = zheJiuMonth;
	}
	public Double getZheJiuPercent() {
		return zheJiuPercent;
	}
	public void setZheJiuPercent(Double zheJiuPercent) {
		this.zheJiuPercent = zheJiuPercent;
	}
	public BigDecimal getZheJiuFeePerMon() {
		return zheJiuFeePerMon;
	}
	public void setZheJiuFeePerMon(BigDecimal zheJiuFeePerMon) {
		this.zheJiuFeePerMon = zheJiuFeePerMon;
	}
	public String getIsDeal() {
		return isDeal;
	}
	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
	}
	public Date getNextYancheDate() {
		return nextYancheDate;
	}
	public void setNextYancheDate(Date nextYancheDate) {
		this.nextYancheDate = nextYancheDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CarInfo [carId=" + carId + ", plateNo=" + plateNo + ", engineNo=" + engineNo + ", carType=" + carType
				+ ", carJiaNo=" + carJiaNo + ", carOwner=" + carOwner + ", carBelong=" + carBelong + ", color=" + color
				+ ", fuelType=" + fuelType + ", buyDate=" + buyDate + ", seller=" + seller + ", carMoney=" + carMoney
				+ ", buyTax=" + buyTax + ", allMoney=" + allMoney + ", zheJiuMonth=" + zheJiuMonth + ", zheJiuPercent="
				+ zheJiuPercent + ", zheJiuFeePerMon=" + zheJiuFeePerMon + ", isDeal=" + isDeal + ", nextYancheDate="
				+ nextYancheDate + ", memo=" + memo + ", status=" + status + "]";
	}
	
}
