package com.dsib.service;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgNews;

public interface GgNewsService {

	public List<Map<String, Object>> initIndex();

	public Map<String, Object> newsDetail(String id);

	public Map<String, Object> getPreviousNews(Map<String, Object> map);

	public Map<String, Object> getNextNews(Map<String, Object> map);

	/**
	 * liao jie geng duo
	 * 
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> newsLookUp(Pagination pagination);

	/**
	 * gong zhong cha xun
	 * 
	 * @param name
	 * @return
	 */
	public List<Map<String, Object>> getPolicy(String name);

	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination);

	/**
	 * 轮播
	 * 
	 * @param pagination
	 * @return
	 */
	public List<Map<String, Object>> getAlternateImg(Pagination pagination);
//	public List<GgNews> getAlternateImg(GgNews ggNews);
	/**
	 * 添加新闻动态
	 * @author hslt
	 * @param news
	 * @return
	 */

	public void getAddNewsAndTrends(GgNews news);

	public void deleteExpect(GgNews ggNews);

	public void updateExpect(GgNews ggNews);

	public List<Map<String, Object>> getAlternateAll(Pagination pagination);

	public String selectExpeNo(GgNews news);

	public void getUpdateNewsAndTrends(GgNews news);

	public List<Map<String, Object>> getContinueByDocType(Pagination pagination);

	public List<Map<String, Object>> getUpdatePhoto();
	
}
