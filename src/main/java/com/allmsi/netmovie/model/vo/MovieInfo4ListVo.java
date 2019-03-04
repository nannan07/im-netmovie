package com.allmsi.netmovie.model.vo;

import java.math.BigDecimal;
import java.util.List;

import com.allmsi.netmovie.model.Movie;

public class MovieInfo4ListVo {

	private String movieId;

	private String movieName;

	private String releaseDate;

	private Integer duration;

	private String movieType;

	private BigDecimal sumBox;

	private List<MDailyVo> dailyBoxList;

	public MovieInfo4ListVo() {

	}

	public MovieInfo4ListVo(Movie movie) {
		if (movie != null) {
			this.movieId = movie.getMovieId();
			this.movieName = movie.getMovieName();
			this.movieType = movie.getMovieType();
			this.releaseDate = movie.getReleaseDate();
			this.duration = movie.getDuration();
			this.sumBox = movie.getSumBox();
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public BigDecimal getSumBox() {
		return sumBox;
	}

	public void setSumBox(BigDecimal sumBox) {
		this.sumBox = sumBox;
	}

	public List<MDailyVo> getDailyBoxList() {
		return dailyBoxList;
	}

	public void setDailyBoxList(List<MDailyVo> dailyBoxList) {
		this.dailyBoxList = dailyBoxList;
	}

}