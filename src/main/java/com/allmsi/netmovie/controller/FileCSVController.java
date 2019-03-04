package com.allmsi.netmovie.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.netmovie.service.FileCSVService;
import com.allmsi.sys.util.CSVUtils;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping("file")
public class FileCSVController {

	@Resource
	private FileCSVService fileCSVService;

	/**
	 * 单日TOP10
	 */
	@RequestMapping(value = "/dailyTop", method = RequestMethod.GET)
	@ResponseBody
	public void movieDailySelect(String dailyDate, HttpServletResponse response) throws IOException {
		if (StrUtil.isEmpty(dailyDate) || (dailyDate.length() != 8)) {
			return;
		}
		String fileName = dailyDate + ".csv";// 文件名称
		String path = fileCSVService.selectDailyTop(dailyDate, fileName);
		CSVUtils.exportFile(response, path, fileName);
	}

	/**
	 * 区间票房统计
	 */
	@RequestMapping(value = "/boxSum", method = RequestMethod.GET)
	@ResponseBody
	public void movieDailyBoxSelect(String startDate, String stopDate, String startReleaseDate,
			String stopReleaseDate, Integer limit, HttpServletResponse response)
			throws IOException {
		if (StrUtil.isEmpty(startDate) || StrUtil.isEmpty(stopDate) || startDate.length() != 8
				|| stopDate.length() != 8) {
			return;
		}
		String fileName = startDate + "--" + stopDate + ".csv";// 文件名称
		String path = fileCSVService.selectBoxSum(startDate, stopDate, startReleaseDate, stopReleaseDate, limit, fileName);
		CSVUtils.exportFile(response, path, fileName);
	}

	/**
	 * 总票房统计
	 * @throws IOException 
	 */
	@RequestMapping(value = "/allSum", method = RequestMethod.GET)
	@ResponseBody
	public void movieBoxSumSelect(String startDate, String stopDate, Integer limit, HttpServletResponse response) throws IOException {
		if ((StrUtil.isEmpty(startDate) && StrUtil.notEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && StrUtil.isEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && startDate.length() != 8)
				|| (StrUtil.notEmpty(stopDate) && stopDate.length() != 8)) {
			return ;
		}
		String fileName = startDate + "--" + stopDate + ".csv";// 文件名称
		String path = fileCSVService.selectAllSum(startDate, stopDate, limit, fileName);
		CSVUtils.exportFile(response, path, fileName);
	}
	
	/**
	 * 上榜统计
	 * @throws IOException 
	 */
	@RequestMapping(value = "/topOrderSum", method = RequestMethod.GET)
	@ResponseBody
	public void topOrderCountSelect(String startDate, String stopDate, Integer limit, HttpServletResponse response) throws IOException {
		if ((StrUtil.isEmpty(startDate) && StrUtil.notEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && StrUtil.isEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && startDate.length() != 8)
				|| (StrUtil.notEmpty(stopDate) && stopDate.length() != 8)) {
			return ;
		}
		String fileName = startDate + "--" + stopDate + ".csv";// 文件名称
		String path = fileCSVService.topOrderCountSelect(startDate, stopDate, limit, fileName);
		CSVUtils.exportFile(response, path, fileName);
	}
	
	/**
	 * 榜首统计
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/topOneSum", method = RequestMethod.GET)
	@ResponseBody
	public void topOneSumSelect(String startDate, String stopDate, Integer limit, HttpServletResponse response) throws IOException {
		if ((StrUtil.isEmpty(startDate) && StrUtil.notEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && StrUtil.isEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && startDate.length() != 8)
				|| (StrUtil.notEmpty(stopDate) && stopDate.length() != 8)) {
			return ;
		}
		String fileName = startDate + "--" + stopDate + ".csv";// 文件名称
		String path = fileCSVService.topOneSumSelect(startDate, stopDate, limit, fileName);
		CSVUtils.exportFile(response, path, fileName);
	}


}
