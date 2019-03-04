package com.allmsi.netmovie.model.vo;

import java.math.BigDecimal;

import com.allmsi.netmovie.model.MovieDaily;

public class MovieAllSumVo {

	private String movieId;

	private String movieName;

	private String releaseDate;

	private BigDecimal dailyBoxMax;

	private BigDecimal sumBox;

	private Byte topOrderMin;

	public MovieAllSumVo() {

	}

	public MovieAllSumVo(MovieDaily movieDaily) {
		if (movieDaily != null) {
			this.movieId = movieDaily.getMovieId();
			this.movieName = movieDaily.getMovieName();
			this.releaseDate = movieDaily.getReleaseDate();
			this.dailyBoxMax = movieDaily.getDailyBox();
			this.sumBox = movieDaily.getSumBox();
			this.topOrderMin = movieDaily.getTopOrder();
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public BigDecimal getDailyBoxMax() {
		return dailyBoxMax;
	}

	public void setDailyBoxMax(BigDecimal dailyBoxMax) {
		this.dailyBoxMax = dailyBoxMax;
	}

	public BigDecimal getSumBox() {
		return sumBox;
	}

	public void setSumBox(BigDecimal sumBox) {
		this.sumBox = sumBox;
	}

	public Byte getTopOrderMin() {
		return topOrderMin;
	}

	public void setTopOrderMin(Byte topOrderMin) {
		this.topOrderMin = topOrderMin;
	}
}