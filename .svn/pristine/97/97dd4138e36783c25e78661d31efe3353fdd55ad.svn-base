/**
 * 
 */
package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgNewsMapper;
import com.dsib.entity.GgEvaluate;
import com.dsib.entity.GgNews;
import com.dsib.service.GgNewsService;

/**
 * @author xinjg
 * 
 */
@Service("ggNewsService")
public final class GgNewsServiceImpl implements GgNewsService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dsib.service.GgNewsService#initIndex()
	 */
	@Autowired
	private GgNewsMapper ggNewsMapper;

	public List<Map<String, Object>> initIndex() {
		List<Map<String, Object>> list = null;
		try {
			list = ggNewsMapper.initIndex();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Map<String, Object> newsDetail(String id) {
		Map<String, Object> map = null;
		try {
			map = ggNewsMapper.newsDetail(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getPreviousNews(Map<String, Object> map1) {
		Map<String, Object> map = null;
		try {
			map = ggNewsMapper.getPreviousNews(map1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getNextNews(Map<String, Object> map1) {
		Map<String, Object> map = null;
		try {
			map = ggNewsMapper.getNextNews(map1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	public List<Map<String, Object>> newsLookUp(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNewsMapper.newsLookUp(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> getPolicy(String name) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNewsMapper.getPolicy(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<GgEvaluate> getComplainAndFeedback(Pagination pagination) {
		List<GgEvaluate> list = null;
		try {
			list = ggNewsMapper.getComplainAndFeedback(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> getAlternateImg(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNewsMapper.getAlternateImg(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/*public List<GgNews> getAlternateImg(GgNews ggNews) {
		List<GgNews> list = null;
		try {
			list = ggNewsMapper.getAlternateImg(ggNews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}*/

	public void getAddNewsAndTrends(GgNews news) {
		try {
			ggNewsMapper.getAddNewsAndTrends(news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public void deleteExpect(GgNews ggNews) {
		try {
			ggNewsMapper.deleteExpect(ggNews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public void updateExpect(GgNews ggNews) {
		try {
			ggNewsMapper.updateExpect(ggNews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public List<Map<String, Object>> getAlternateAll(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNewsMapper.getAlternateAll(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String selectExpeNo(GgNews ggNews) {
		String list = null;
		try {
			list = ggNewsMapper.selectExpeNo(ggNews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void getUpdateNewsAndTrends(GgNews news) {
		try {
			ggNewsMapper.getUpdateNewsAndTrends(news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public List<Map<String, Object>> getContinueByDocType(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNewsMapper.getContinueByDocType(pagination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> getUpdatePhoto() {
		List<Map<String, Object>> list = null;
		try {
			list = ggNewsMapper.getUpdatePhoto();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
