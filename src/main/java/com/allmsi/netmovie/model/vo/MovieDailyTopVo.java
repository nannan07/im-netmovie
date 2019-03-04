package com.allmsi.netmovie.model.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.allmsi.netmovie.model.MovieDaily;

public class MovieDailyTopVo {

	private String movieId;

	private String movieName;

	private String dailyDate;

	private String releaseDate;

	private Short releaseDays;

	private BigDecimal dailyBox;

	private BigDecimal sumBox;

	private Byte topOrder;

	private String growthRate;

	private Date createdAt;

	private String uplift;

	public MovieDailyTopVo() {

	}

	public MovieDailyTopVo(MovieDaily movieDaily) {
		if (movieDaily != null) {
			this.movieId = movieDaily.getMovieId();
			this.movieName = movieDaily.getMovieName();
			this.dailyDate = movieDaily.getDailyDate();
			this.releaseDate = movieDaily.getReleaseDate();
			this.releaseDays = movieDaily.getReleaseDays();
			this.dailyBox = movieDaily.getDailyBox();
			this.sumBox = movieDaily.getSumBox();
			this.topOrder = movieDaily.getTopOrder();
			this.createdAt = movieDaily.getCreatedAt();
			this.uplift = movieDaily.getUplift();
			this.growthRate = movieDaily.getGrowthRate();
		}
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId == null ? null : movieId.trim();
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName == null ? null : movieName.trim();
	}

	public String getDailyDate() {
		return dailyDate;
	}

	public void setDailyDate(String dailyDate) {
		this.dailyDate = dailyDate == null ? null : dailyDate.trim();
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate == null ? null : releaseDate.trim();
	}

	public Short getReleaseDays() {
		return releaseDays;
	}

	public void setReleaseDays(Short releaseDays) {
		this.releaseDays = releaseDays;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUplift() {
		return uplift;
	}

	public void setUplift(String uplift) {
		this.uplift = uplift;
	}

	public String getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(String growthRate) {
		this.growthRate = growthRate;
	}

}