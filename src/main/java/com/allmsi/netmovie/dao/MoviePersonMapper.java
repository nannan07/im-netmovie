package com.allmsi.netmovie.dao;

import java.util.List;

import com.allmsi.netmovie.model.MoviePerson;

public interface MoviePersonMapper {
	List<MoviePerson> selectByMovieId(String movieId);
}