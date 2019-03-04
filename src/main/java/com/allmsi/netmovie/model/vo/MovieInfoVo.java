package com.allmsi.netmovie.model.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.allmsi.netmovie.model.Movie;

public class MovieInfoVo {

	private String movieId;

	private String movieName;

	private String releaseDate;

	private Integer duration;

	private String summary;

	private String movieType;

	private BigDecimal sumBox;

	private Map<String, List<MPersonVo>> personMap;

	private List<MDailyVo> dailyBoxList;

	public MovieInfoVo() {

	}

	public MovieInfoVo(Movie movie) {
		if (movie != null) {
			this.movieId = movie.getMovieId();
			this.movieName = movie.getMovieName();
			this.movieType = movie.getMovieType();
			this.releaseDate = movie.getReleaseDate();
			this.duration = movie.getDuration();
			this.summary = movie.getSummary();
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public Map<String, List<MPersonVo>> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<String, List<MPersonVo>> personMap) {
		this.personMap = personMap;
	}

	public List<MDailyVo> getDailyBoxList() {
		return dailyBoxList;
	}

	public void setDailyBoxList(List<MDailyVo> dailyBoxList) {
		this.dailyBoxList = dailyBoxList;
	}

}