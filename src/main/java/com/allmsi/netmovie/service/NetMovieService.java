package com.allmsi.netmovie.service;

import java.util.List;

import com.allmsi.netmovie.model.vo.MovieAllSumVo;
import com.allmsi.netmovie.model.vo.MovieBoxSumVo;
import com.allmsi.netmovie.model.vo.MovieCTopOrderVo;
import com.allmsi.netmovie.model.vo.MovieDailyTopVo;
import com.allmsi.netmovie.model.vo.MovieInfo4ListVo;
import com.allmsi.netmovie.model.vo.MovieInfoVo;
import com.allmsi.netmovie.model.vo.MovieListVo;
import com.allmsi.netmovie.model.vo.MovieTopOrderVo;

public interface NetMovieService {
	List<MovieDailyTopVo> selectDailyTop(String dailyDate);

	List<MovieBoxSumVo> selectBoxSum(String startDate, String stopDate, String startReleaseDate, String stopReleaseDate,
			Integer limit);

	MovieInfoVo selectMovieInfo(String movieId);

	List<MovieAllSumVo> selectAllSum(String startDate, String stopDate, Integer limit);

	List<MovieTopOrderVo> topOrderCountSelect(String startDate, String stopDate, Integer limit);

	List<MovieTopOrderVo> topOneSumSelect(String startDate, String stopDate, Integer limit);

	List<MovieCTopOrderVo> continuityTopOneSelect(Integer topOrder, Integer limit);

	int movieListCountSelect(String name);

	List<MovieListVo> movieListSelect(String name, Integer page, Integer pageSize);

	List<MovieInfo4ListVo> compareInfoSelect(List<String> movieIds);
}
