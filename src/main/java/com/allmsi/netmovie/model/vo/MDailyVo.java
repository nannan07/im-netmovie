package com.allmsi.netmovie.model.vo;

import java.math.BigDecimal;

import com.allmsi.netmovie.model.MovieDaily;

public class MDailyVo {

	private String dailyDate;

	private BigDecimal dailyBox;

	private BigDecimal sumBox;

	private Byte topOrder;

	public MDailyVo() {

	}

	public MDailyVo(MovieDaily movieDaily) {
		if (movieDaily != null) {
			this.dailyDate = movieDaily.getDailyDate();
			this.dailyBox = movieDaily.getDailyBox();
			this.sumBox = movieDaily.getSumBox();
			this.topOrder = movieDaily.getTopOrder();
		}
	}

	public String getDailyDate() {
		return dailyDate;
	}

	public void setDailyDate(String dailyDate) {
		this.dailyDate = dailyDate;
	}

	public BigDecimal getDailyBox() {
		return dailyBox;
	}

	public void setDailyBox(BigDecimal dailyBox) {
		this.dailyBox = dailyBox;
	}

	public BigDecimal getSumBox() {
		return sumBox;
	}

	public void setSumBox(BigDecimal sumBox) {
		this.sumBox = sumBox;
	}

	public Byte getTopOrder() {
		return topOrder;
	}

	public void setTopOrder(Byte topOrder) {
		this.topOrder = topOrder;
	}
}
