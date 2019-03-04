package com.allmsi.netmovie.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.netmovie.dao.MovieDailyMapper;
import com.allmsi.netmovie.dao.MovieMapper;
import com.allmsi.netmovie.dao.MoviePersonMapper;
import com.allmsi.netmovie.model.Movie;
import com.allmsi.netmovie.model.MovieDaily;
import com.allmsi.netmovie.model.MoviePerson;
import com.allmsi.netmovie.model.vo.MDailyVo;
import com.allmsi.netmovie.model.vo.MPersonVo;
import com.allmsi.netmovie.model.vo.MovieAllSumVo;
import com.allmsi.netmovie.model.vo.MovieBoxSumVo;
import com.allmsi.netmovie.model.vo.MovieCTopOrderVo;
import com.allmsi.netmovie.model.vo.MovieDailyTopVo;
import com.allmsi.netmovie.model.vo.MovieInfo4ListVo;
import com.allmsi.netmovie.model.vo.MovieInfoVo;
import com.allmsi.netmovie.model.vo.MovieListVo;
import com.allmsi.netmovie.model.vo.MovieTopOrderVo;
import com.allmsi.netmovie.service.NetMovieService;
import com.allmsi.sys.util.StrUtil;
import com.github.pagehelper.PageHelper;

@Service
public class NetMovieServiceImpl implements NetMovieService {

	@Resource
	private MovieDailyMapper movieDailyDao;

	@Resource
	private MovieMapper movieDao;

	@Resource
	private MoviePersonMapper moviePersonDao;

	@Override
	public List<MovieDailyTopVo> selectDailyTop(String dailyDate) {
		List<MovieDailyTopVo> list = new ArrayList<MovieDailyTopVo>();
		List<MovieDaily> dailyList = movieDailyDao.selectByDailyDate(dailyDate);
		for (MovieDaily movieDaily : dailyList) {
			list.add(new MovieDailyTopVo(movieDaily));
		}
		return list;
	}

	@Override
	public List<MovieBoxSumVo> selectBoxSum(String startDate, String stopDate, String startReleaseDate,
			String stopReleaseDate, Integer limit) {
		List<MovieBoxSumVo> list = new ArrayList<MovieBoxSumVo>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("stopDate", stopDate);
		map.put("startReleaseDate", startReleaseDate);
		map.put("stopReleaseDate", stopReleaseDate);
		if (limit != null && limit > 0) {
			map.put("limit", limit);
		} else {
			map.put("limit", 10);
		}
		List<MovieDaily> dailyList = movieDailyDao.movieDailyBoxSelect(map);
		for (MovieDaily movieDaily : dailyList) {
			list.add(new MovieBoxSumVo(movieDaily));
		}
		return list;
	}

	@Override
	public List<MovieAllSumVo> selectAllSum(String startDate, String stopDate, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("stopDate", stopDate);
		if (limit != null && limit > 0) {
			map.put("limit", limit);
		} else {
			map.put("limit", 10);
		}
		List<MovieDaily> dailyList = movieDailyDao.movieBoxSumSelect(map);
		List<MovieAllSumVo> list = new ArrayList<MovieAllSumVo>();
		for (MovieDaily movieDaily : dailyList) {
			list.add(new MovieAllSumVo(movieDaily));
		}
		return list;
	}

	@Override
	public MovieInfoVo selectMovieInfo(String movieId) {
		Movie movie = movieDao.selectByPrimaryKey(movieId);
		MovieInfoVo movieVo = new MovieInfoVo(movie);
		BigDecimal sumBox = movieDailyDao.selectSumBox(movieId);
		movieVo.setSumBox(sumBox);
		List<MoviePerson> mpList = moviePersonDao.selectByMovieId(movieId);
		Map<String, List<MPersonVo>> map = new HashMap<String, List<MPersonVo>>();
		for (MoviePerson moviePerson : mpList) {
			String key = moviePerson.getTypeName();
			MPersonVo value = new MPersonVo(moviePerson);
			if (map.containsKey(key)) {
				map.get(key).add(value);
			} else {
				List<MPersonVo> list = new ArrayList<MPersonVo>();
				list.add(value);
				map.put(key, list);
			}
		}
		movieVo.setPersonMap(map);
		List<MovieDaily> mdList = movieDailyDao.selectByMovieId(movieId);
		List<MDailyVo> dailyBoxList = new ArrayList<MDailyVo>();
		for (MovieDaily movieDaily : mdList) {
			dailyBoxList.add(new MDailyVo(movieDaily));
		}
		movieVo.setDailyBoxList(dailyBoxList);
		return movieVo;
	}

	@Override
	public List<MovieTopOrderVo> topOrderCountSelect(String startDate, String stopDate, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("stopDate", stopDate);
		if (limit != null && limit > 0) {
			map.put("limit", limit);
		} else {
			map.put("limit", 10);
		}
		List<MovieTopOrderVo> list = new ArrayList<MovieTopOrderVo>();
		List<MovieDaily> dailyList = movieDailyDao.topOrderCountSelect(map);
		for (MovieDaily movieDaily : dailyList) {
			list.add(new MovieTopOrderVo(movieDaily));
		}
		return list;
	}

	@Override
	public List<MovieTopOrderVo> topOneSumSelect(String startDate, String stopDate, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("stopDate", stopDate);
		if (limit != null && limit > 0) {
			map.put("limit", limit);
		} else {
			map.put("limit", 10);
		}
		List<MovieTopOrderVo> list = new ArrayList<MovieTopOrderVo>();
		List<MovieDaily> dailyList = movieDailyDao.topOneSumSelect(map);
		for (MovieDaily movieDaily : dailyList) {
			list.add(new MovieTopOrderVo(movieDaily));
		}
		return list;
	}

	@Override
	public List<MovieCTopOrderVo> continuityTopOneSelect(Integer topOrder, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (topOrder != null && topOrder > 0) {
			map.put("topOrder", topOrder);
		} else {
			map.put("topOrder", 1);
		}
		if (limit != null && limit > 0) {
			map.put("limit", limit);
		} else {
			map.put("limit", 10);
		}
		List<MovieDaily> mdlist = movieDailyDao.continuityTopOneSelect(map);
		List<MovieCTopOrderVo> list = new ArrayList<MovieCTopOrderVo>();
		for (MovieDaily movieDaily : mdlist) {
			list.add(new MovieCTopOrderVo(movieDaily));
		}
		return list;
	}

	@Override
	public int movieListCountSelect(String name) {
		List<String> list = new ArrayList<String>();
		if (StrUtil.notEmpty(name)) {
			String[] names = name.split("#");
			list.addAll(Arrays.asList(names));
		}
		int total = movieDao.movieListCountSelect(list);
		return total;
	}

	@Override
	public List<MovieListVo> movieListSelect(String name, Integer page, Integer pageSize) {
		List<String> strings = new ArrayList<String>();
		if (StrUtil.notEmpty(name)) {
			String[] names = name.split("#");
			strings.addAll(Arrays.asList(names));
		}
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		List<Movie> mlist = movieDao.movieListSelect(strings);
		List<MovieListVo> list = new ArrayList<MovieListVo>();
		for (Movie movie : mlist) {
			list.add(new MovieListVo(movie));
		}
		return list;
	}

	@Override
	public List<MovieInfo4ListVo> compareInfoSelect(List<String> movieIds) {
		List<MovieInfo4ListVo> list = new ArrayList<MovieInfo4ListVo>();
		List<Movie> mList = movieDao.compareInfoSelect(movieIds);
		for (Movie movie : mList) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("moviedId", movie.getMovieId());
			param.put("releaseDate", movie.getReleaseDate());
			List<MovieDaily> mdList = movieDailyDao.compareInfoSelect(param);
			List<MDailyVo> dailyBoxList = new ArrayList<MDailyVo>();
			for (MovieDaily movieDaily : mdList) {
				dailyBoxList.add(new MDailyVo(movieDaily));
			}
			MovieInfo4ListVo mi = new MovieInfo4ListVo(movie);
			mi.setDailyBoxList(dailyBoxList);
			list.add(mi);
		}
		return list;
	}

}
