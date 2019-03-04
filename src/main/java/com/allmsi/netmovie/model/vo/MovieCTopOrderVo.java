package com.allmsi.netmovie.model.vo;

import com.allmsi.netmovie.model.MovieDaily;

public class MovieCTopOrderVo {
	private String movieId;

	private String movieName;

	private String releaseDate;

	private Integer count;

	private String startDate;

	private String endDate;

	public MovieCTopOrderVo() {

	}

	public MovieCTopOrderVo(MovieDaily movieDaily) {
		if (movieDaily != null) {
			this.movieId = movieDaily.getMovieId();
			this.movieName = movieDaily.getMovieName();
			this.releaseDate = movieDaily.getReleaseDate();
			this.count = movieDaily.getTopCount();
			this.startDate = movieDaily.getStartDate();
			this.endDate = movieDaily.getEndDate();
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
