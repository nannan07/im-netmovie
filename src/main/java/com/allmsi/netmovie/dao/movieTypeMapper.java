package com.allmsi.netmovie.dao;

import com.allmsi.netmovie.model.movieType;

public interface movieTypeMapper {
    movieType selectByPrimaryKey(String id);
}