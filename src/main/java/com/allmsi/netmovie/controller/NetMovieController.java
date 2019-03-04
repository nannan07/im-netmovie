package com.allmsi.netmovie.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allmsi.netmovie.model.protocol.SuccessProtocol;
import com.allmsi.netmovie.model.protocol.WarnProtocol;
import com.allmsi.netmovie.service.NetMovieService;
import com.allmsi.sys.model.ListBean;
import com.allmsi.sys.util.StrUtil;

@Controller
@RequestMapping("netmovie")
public class NetMovieController {

	@Resource
	private NetMovieService netMovieService;

	/**
	 * 当日的排行榜，排行名次升序
	 * 
	 * @param dailyDate
	 *            查询日期
	 * @return
	 */
	@RequestMapping(value = "/dailyTop", method = RequestMethod.GET)
	@ResponseBody
	public Object movieDailySelect(String dailyDate) {
		if (StrUtil.isEmpty(dailyDate) || (dailyDate.length() != 8)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(new ListBean(netMovieService.selectDailyTop(dailyDate)));
	}

	/**
	 * 根据时间段统计日分成额总和，降序
	 * 
	 * @param startDate
	 *            开始日期
	 * @param stopDate
	 *            结束日期
	 * @param limit
	 *            显示条数，默认10条
	 * @return
	 */
	@RequestMapping(value = "/boxSum", method = RequestMethod.GET)
	@ResponseBody
	public Object movieDailyBoxSelect(String startDate, String stopDate, String startReleaseDate,
			String stopReleaseDate, Integer limit) {
		if (StrUtil.isEmpty(startDate) || StrUtil.isEmpty(stopDate) || startDate.length() != 8 || stopDate.length() != 8
				|| (StrUtil.notEmpty(startReleaseDate) && startReleaseDate.length() != 8)
				|| (StrUtil.notEmpty(stopReleaseDate) && stopReleaseDate.length() != 8)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(new ListBean(netMovieService.selectBoxSum(startDate, stopDate, startReleaseDate, stopReleaseDate, limit)));
	}

	/**
	 * 通过上映时间段统计，日总分成额，最佳排名。sumBox降序
	 * 
	 * @param startDate
	 *            开始日期
	 * @param stopDate
	 *            结束日期
	 * @param limit
	 *            显示条数，默认10条
	 * @return
	 */
	@RequestMapping(value = "/allSum", method = RequestMethod.GET)
	@ResponseBody
	public Object movieBoxSumSelect(String startDate, String stopDate, Integer limit) {
		if ((StrUtil.isEmpty(startDate) && StrUtil.notEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && StrUtil.isEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && startDate.length() != 8)
				|| (StrUtil.notEmpty(stopDate) && stopDate.length() != 8)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(new ListBean(netMovieService.selectAllSum(startDate, stopDate, limit)));
	}

	/**
	 * 影片详细信息
	 * 
	 * @param movieId
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Object movieInfoSelect(String movieId) {
		if (StrUtil.isEmpty(movieId)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol("", netMovieService.selectMovieInfo(movieId));
	}

	/**
	 * 根据时间段统计影片上榜次数，根据上榜次数降序
	 * 
	 * @param startDate
	 *            开始日期
	 * @param stopDate
	 *            结束日期
	 * @param limit
	 *            显示条数，默认10条
	 * @return
	 */
	@RequestMapping(value = "/topOrderSum", method = RequestMethod.GET)
	@ResponseBody
	public Object topOrderCountSelect(String startDate, String stopDate, Integer limit) {
		if ((StrUtil.isEmpty(startDate) && StrUtil.notEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && StrUtil.isEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && startDate.length() != 8)
				|| (StrUtil.notEmpty(stopDate) && stopDate.length() != 8)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(new ListBean(netMovieService.topOrderCountSelect(startDate, stopDate, limit)));
	}

	/**
	 * 根据时间段统计排名第一的次数，按次数降序，上映日期升序
	 * 
	 * @param startDate
	 *            开始日期
	 * @param stopDate
	 *            结束日期
	 * @param limit
	 *            显示条数，默认10条
	 * @return
	 */
	@RequestMapping(value = "/topOneSum", method = RequestMethod.GET)
	@ResponseBody
	public Object topOneSumSelect(String startDate, String stopDate, Integer limit) {
		if ((StrUtil.isEmpty(startDate) && StrUtil.notEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && StrUtil.isEmpty(stopDate))
				|| (StrUtil.notEmpty(startDate) && startDate.length() != 8)
				|| (StrUtil.notEmpty(stopDate) && stopDate.length() != 8)) {
			return new WarnProtocol();
		}
		return new SuccessProtocol(new ListBean(netMovieService.topOneSumSelect(startDate, stopDate, limit)));
	}

	/**
	 * 连续排名第几的最大次数，按次数降序
	 * 
	 * @param topOrder
	 *            默认第一
	 * @param limit
	 *            显示条数，默认10条
	 * @return
	 */
	@RequestMapping(value = "/continuityTop", method = RequestMethod.GET)
	@ResponseBody
	public Object continuityTopOneSelect(Integer topOrder, Integer limit) {
		return new SuccessProtocol(new ListBean(netMovieService.continuityTopOneSelect(topOrder, limit)));
	}

	/**
	 * 条件查询影片列表，上映日期降序
	 * 
	 * @param movieName
	 *            模糊查询，可以为空
	 * @param typeName
	 *            可以为空
	 * @param page
	 *            第几页，默认第一页
	 * @param pageSize
	 *            每页条数，默认10条
	 * @return
	 */
	@RequestMapping(value = "/movieList", method = RequestMethod.GET)
	@ResponseBody
	public Object movieListSelect(String name, Integer page, Integer pageSize) {
		int total = netMovieService.movieListCountSelect(name);
		return new SuccessProtocol(new ListBean(total, netMovieService.movieListSelect(name, page, pageSize)));
	}

	/**
	 * 多个影片信息
	 * 
	 * @param movieIds
	 * @return
	 */
	@RequestMapping(value = "/compareInfo", method = RequestMethod.GET)
	@ResponseBody
	public Object compareInfoSelect(String movieIds) {
		if (StrUtil.isEmpty(movieIds)) {
			return new WarnProtocol();
		}
		String[] strings = movieIds.split(",");
		List<String> movieList = Arrays.asList(strings);
		return new SuccessProtocol(new ListBean(strings.length, netMovieService.compareInfoSelect(movieList)));
	}

}
