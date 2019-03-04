package com.allmsi.netmovie.model.vo;

import java.math.BigDecimal;

import com.allmsi.netmovie.model.MovieDaily;

public class MovieBoxSumVo {

	private String movieId;

	private String movieName;

	private String dailyDateMax;

	private String releaseDate;

	private Short releaseDays;

	private BigDecimal dailyBoxSum;

	private BigDecimal sumBox;

	public MovieBoxSumVo() {

	}

	public MovieBoxSumVo(MovieDaily movieDaily) {
		if (movieDaily != null) {
			this.movieId = movieDaily.getMovieId();
			this.movieName = movieDaily.getMovieName();
			this.dailyDateMax = movieDaily.getDailyDate();
			this.releaseDate = movieDaily.getReleaseDate();
			this.releaseDays = movieDaily.getReleaseDays();
			this.dailyBoxSum = movieDaily.getDailyBox();
			this.sumBox = movieDaily.getSumBox();
		}
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDailyDateMax() {
		return dailyDateMax;
	}

	public void setDailyDateMax(String dailyDateMax) {
		this.dailyDateMax = dailyDateMax;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Short getReleaseDays() {
		return releaseDays;
	}

	public void setReleaseDays(Short releaseDays) {
		this.releaseDays = releaseDays;
	}

	public BigDecimal getDailyBoxSum() {
		return dailyBoxSum;
	}

	public void setDailyBoxSum(BigDecimal dailyBoxSum) {
		this.dailyBoxSum = dailyBoxSum;
	}

	public BigDecimal getSumBox() {
		return sumBox;
	}

	public void setSumBox(BigDecimal sumBox) {
		this.sumBox = sumBox;
	}
}