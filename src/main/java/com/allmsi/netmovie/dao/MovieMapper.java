package com.allmsi.netmovie.dao;

import java.util.List;

import com.allmsi.netmovie.model.Movie;
public interface MovieMapper {
    Movie selectByPrimaryKey(String id);

	List<Movie> movieListSelect(List<String> strings);

	List<Movie> compareInfoSelect(List<String> movieIds);

	int movieListCountSelect(List<String> list);
}