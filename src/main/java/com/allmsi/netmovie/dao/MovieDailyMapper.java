package com.allmsi.netmovie.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.allmsi.netmovie.model.MovieDaily;

public interface MovieDailyMapper {
 
	List<MovieDaily> selectByDailyDate(String dailyDate);

	List<MovieDaily> movieDailyBoxSelect(Map<String, Object> map);

	List<MovieDaily> movieBoxSumSelect(Map<String, Object> map);

	List<MovieDaily> selectByMovieId(String movieId);

	BigDecimal selectSumBox(String movieId);

	List<MovieDaily> topOrderCountSelect(Map<String, Object> map);

	List<MovieDaily> topOneSumSelect(Map<String, Object> map);
	
	List<MovieDaily> continuityTopOneSelect(Map<String, Object> map);

	List<MovieDaily> compareInfoSelect(Map<String, Object> param);
}