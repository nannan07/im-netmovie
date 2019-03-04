package com.allmsi.netmovie.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allmsi.netmovie.model.vo.MovieAllSumVo;
import com.allmsi.netmovie.model.vo.MovieBoxSumVo;
import com.allmsi.netmovie.model.vo.MovieDailyTopVo;
import com.allmsi.netmovie.model.vo.MovieTopOrderVo;
import com.allmsi.netmovie.service.FileCSVService;
import com.allmsi.netmovie.service.NetMovieService;
import com.allmsi.sys.config.PropertyConfig;
import com.allmsi.sys.util.CSVUtils;
import com.allmsi.sys.util.StrUtil;

@Service
public class FileCSVServiceImpl implements FileCSVService {

	private final String FILE_PATH = "im.file.path"; // 文件路径

	@Resource
	private NetMovieService netMovieService;

	@Resource
	private PropertyConfig propertyConfig;

	@Override
	public String selectDailyTop(String dailyDate, String fileName) {
		// 表格头
		Object[] head = { "影片名称", "上线日期	", "上线天数", "日票房(万)", "总票房(万)", "排名升降", };
		List<Object> headList = Arrays.asList(head);

		// 数据
		List<MovieDailyTopVo> list = netMovieService.selectDailyTop(dailyDate);
		if (list != null && list.size() > 0) {
			List<List<Object>> dataList = new ArrayList<List<Object>>();
			List<Object> rowList = null;
			for (MovieDailyTopVo movieDailyTopVo : list) {
				rowList = new ArrayList<Object>();
				rowList.add(movieDailyTopVo.getMovieName());
				rowList.add(movieDailyTopVo.getReleaseDate());
				rowList.add(movieDailyTopVo.getReleaseDays());
				rowList.add(movieDailyTopVo.getDailyBox());
				rowList.add(movieDailyTopVo.getSumBox());
				rowList.add(movieDailyTopVo.getTopOrder());
				dataList.add(rowList);
			}
			String defaultPath = propertyConfig.getProperty(FILE_PATH);
			if (StrUtil.isEmpty(defaultPath)) {
				return "";
			}
			String filePath = defaultPath + "/单日TOP10/" + dailyDate.substring(0, 4) + "/" + dailyDate.substring(4, 6)
					+ "/" + dailyDate.substring(6, 8) + "/";
			return CSVUtils.createCSV(headList, dataList, fileName, filePath).getPath();
		} else {
			return "";
		}

	}

	@Override
	public String selectBoxSum(String startDate, String stopDate, String startReleaseDate, String stopReleaseDate,
			Integer limit, String fileName) {
		// 表格头
		Object[] head = { "影片名称", "上线日期	", "区间票房(万)", "总票房(万)", };
		List<Object> headList = Arrays.asList(head);

		List<MovieBoxSumVo> list = netMovieService.selectBoxSum(startDate, stopDate, startReleaseDate, stopReleaseDate,
				limit);
		if (list != null && list.size() > 0) {
			List<List<Object>> dataList = new ArrayList<List<Object>>();
			List<Object> rowList = null;
			for (MovieBoxSumVo movieBoxSumVo : list) {
				rowList = new ArrayList<Object>();
				rowList.add(movieBoxSumVo.getMovieName());
				rowList.add(movieBoxSumVo.getReleaseDate());
				rowList.add(movieBoxSumVo.getDailyBoxSum());
				rowList.add(movieBoxSumVo.getSumBox());

				dataList.add(rowList);
			}
			String defaultPath = propertyConfig.getProperty(FILE_PATH);
			if (StrUtil.isEmpty(defaultPath)) {
				return "";
			}
			String filePath = defaultPath + "/区间票房统计/" + startDate.substring(0, 4) + "/" + startDate.substring(4, 6)
					+ "/" + startDate.substring(6, 8) + "/";
			return CSVUtils.createCSV(headList, dataList, fileName, filePath).getPath();
		} else {
			return "";
		}
	}

	@Override
	public String selectAllSum(String startDate, String stopDate, Integer limit, String fileName) {
		// 表格头
		Object[] head = { "影片名称", "上线日期	", "总票房(万)", "日最高(万)", "日最高排名", };
		List<Object> headList = Arrays.asList(head);

		List<MovieAllSumVo> list = netMovieService.selectAllSum(startDate, stopDate, limit);
		if (list != null && list.size() > 0) {
			List<List<Object>> dataList = new ArrayList<List<Object>>();
			List<Object> rowList = null;
			for (MovieAllSumVo movieAllSumVo : list) {
				rowList = new ArrayList<Object>();
				rowList.add(movieAllSumVo.getMovieName());
				rowList.add(movieAllSumVo.getReleaseDate());
				rowList.add(movieAllSumVo.getSumBox());
				rowList.add(movieAllSumVo.getDailyBoxMax());
				rowList.add(movieAllSumVo.getTopOrderMin());

				dataList.add(rowList);
			}
			String defaultPath = propertyConfig.getProperty(FILE_PATH);
			if (StrUtil.isEmpty(defaultPath)) {
				return "";
			}
			String filePath = defaultPath + "/总票房统计/" + startDate.substring(0, 4) + "/" + startDate.substring(4, 6)
					+ "/" + startDate.substring(6, 8) + "/";
			return CSVUtils.createCSV(headList, dataList, fileName, filePath).getPath();
		} else {
			return "";
		}
	}

	@Override
	public String topOrderCountSelect(String startDate, String stopDate, Integer limit, String fileName) {
		// 表格头
		Object[] head = { "影片名称", "上线日期	", "上榜次数", };
		List<Object> headList = Arrays.asList(head);

		List<MovieTopOrderVo> list = netMovieService.topOrderCountSelect(startDate, stopDate, limit);
		if (list != null && list.size() > 0) {
			List<List<Object>> dataList = new ArrayList<List<Object>>();
			List<Object> rowList = null;
			for (MovieTopOrderVo movieTopOrderVo : list) {
				rowList = new ArrayList<Object>();
				rowList.add(movieTopOrderVo.getMovieName());
				rowList.add(movieTopOrderVo.getReleaseDate());
				rowList.add(movieTopOrderVo.getCount());
				dataList.add(rowList);
			}
			String defaultPath = propertyConfig.getProperty(FILE_PATH);
			if (StrUtil.isEmpty(defaultPath)) {
				return "";
			}
			String filePath = defaultPath + "/上榜统计/" + startDate.substring(0, 4) + "/" + startDate.substring(4, 6) + "/"
					+ startDate.substring(6, 8) + "/";
			return CSVUtils.createCSV(headList, dataList, fileName, filePath).getPath();
		} else {
			return "";
		}
	}

	@Override
	public String topOneSumSelect(String startDate, String stopDate, Integer limit, String fileName) {
		// 表格头
		Object[] head = { "影片名称", "上线日期	", "榜首次数", };
		List<Object> headList = Arrays.asList(head);

		List<MovieTopOrderVo> list = netMovieService.topOneSumSelect(startDate, stopDate, limit);
		if (list != null && list.size() > 0) {
			List<List<Object>> dataList = new ArrayList<List<Object>>();
			List<Object> rowList = null;
			for (MovieTopOrderVo movieTopOrderVo : list) {
				rowList = new ArrayList<Object>();
				rowList.add(movieTopOrderVo.getMovieName());
				rowList.add(movieTopOrderVo.getReleaseDate());
				rowList.add(movieTopOrderVo.getCount());
				dataList.add(rowList);
			}
			String defaultPath = propertyConfig.getProperty(FILE_PATH);
			if (StrUtil.isEmpty(defaultPath)) {
				return "";
			}
			String filePath = defaultPath + "/榜首统计/" + startDate.substring(0, 4) + "/" + startDate.substring(4, 6) + "/"
					+ startDate.substring(6, 8) + "/";
			return CSVUtils.createCSV(headList, dataList, fileName, filePath).getPath();
		} else {
			return "";
		}
	}

}
