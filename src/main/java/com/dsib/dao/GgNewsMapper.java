package com.dsib.dao;

import java.util.List;
import java.util.Map;

import com.dsib.common.Pagination;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgNews;

public interface GgNewsMapper {

	public List<Map<String, Object>> initIndex() throws Exception;

	// 查看详情
	public Map<String, Object> newsDetail(String id) throws Exception;

	// 上一篇
	public Map<String, Object> getPreviousNews(Map<String, Object> map)
			throws Exception;

	// 下一篇
	public Map<String, Object> getNextNews(Map<String, Object> map)
			throws Exception;

	public List<Map<String, Object>> newsLookUp(Pagination pagination)
			throws Exception;

	// 公众查询
	public List<Map<String, Object>> getPolicy(String name) throws Exception;

	// 公众参与
	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination)
			throws Exception;

	// 轮播图片
//	public List<GgNews> getAlternateImg(GgNews ggNews) throws Exception;
	public List<Map<String, Object>> getAlternateImg(Pagination map);
	/**
	 * 添加新闻动态
	 * @author hslt
	 * @param news
	 */
	public void getAddNewsAndTrends(GgNews news);

	public void deleteExpect(GgNews ggNews);

	public void updateExpect(GgNews ggNews);

	public List<Map<String, Object>> getAlternateAll(Pagination pagination);

	public String selectExpeNo(GgNews ggNews);

	public void getUpdateNewsAndTrends(GgNews news);

	public List<Map<String, Object>> getContinueByDocType(Pagination pagination);

	public List<Map<String, Object>> getUpdatePhoto();

	//新添加方法
	int deleteByPrimaryKey(String docid);

    int insert(GgNews record);

    int insertSelective(GgNews record);

    GgNews selectByPrimaryKey(String docid);

    int updateByPrimaryKeySelective(GgNews record);

    int updateByPrimaryKeyWithBLOBs(GgNews record);

    int updateByPrimaryKey(GgNews record);
}
