package com.allmsi.netmovie.service;

public interface FileCSVService {

	String selectDailyTop(String dailyDate, String fileName);

	String selectBoxSum(String startDate, String stopDate, String startReleaseDate, String stopReleaseDate,
			Integer limit, String fileName);

	String selectAllSum(String startDate, String stopDate, Integer limit, String fileName);

	String topOrderCountSelect(String startDate, String stopDate, Integer limit, String fileName);

	String topOneSumSelect(String startDate, String stopDate, Integer limit, String fileName);

}
