package com.allmsi.netmovie.model.vo;

import com.allmsi.netmovie.model.MovieDaily;

public class MovieTopOrderVo {
	private String movieId;

	private String movieName;
	
	 private String releaseDate;

	private Integer count;

	public MovieTopOrderVo() {

	}

	public MovieTopOrderVo(MovieDaily movieDaily) {
		if (movieDaily != null) {
			this.movieId = movieDaily.getMovieId();
			this.movieName = movieDaily.getMovieName();
			this.releaseDate = movieDaily.getReleaseDate();
			this.count = movieDaily.getTopCount();
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
}
