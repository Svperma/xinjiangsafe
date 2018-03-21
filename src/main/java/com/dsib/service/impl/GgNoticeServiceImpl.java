package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgNoticeMapper;
import com.dsib.dao.GgUserMapper;
import com.dsib.entity.GgNotice;
import com.dsib.entity.GgUser;
import com.dsib.service.GgNoticeService;

@Service("ggNoticeService")
public class GgNoticeServiceImpl implements GgNoticeService {
	@Autowired
	private GgNoticeMapper ggNoticeMapper;
	@Autowired
	private GgUserMapper ggUserMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询所有消息列表
	 * 
	 * @author hslt
	 */
	public List<Map<String, Object>> selectList(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.selectList(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 插入通知信息
	 * 
	 * @author hslt
	 */
	public void insertList(GgNotice ggNotice) {
		try {
			ggNoticeMapper.insertList(ggNotice);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 
	 * 有条件的查询通知信息 条件查询通知信息
	 * 
	 * @author hslt
	 */
	public List<Map<String, Object>> queryList(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.queryList(map);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 更新通知信息
	 */
	public void updateList(GgNotice ggNotice) {
		try {
			ggNoticeMapper.updateList(ggNotice);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 查询所有消息
	 * 
	 * @author hslt
	 */
	public List<Map<String, Object>> queryListAll(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.queryListAll(map);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return list;
	}

	public String selectListAllByRecipient(String map) {
		String content = null;
		try {
			content = ggNoticeMapper.selectListAllByRecipient(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

	public Integer getCountByNotice(GgNotice notice) {
		Integer list = null;
		try {
			list = ggNoticeMapper.getCountByNotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> querySeriesNo(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.querySeriesNo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void updateMarkRead(GgNotice ggNotice) {
		// TODO Auto-generated method stub
		ggNoticeMapper.updateMarkRead(ggNotice);
	}

	/**
	 * 查询通知列表
	 */
	public List<Map<String, Object>> noticeList(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.noticeList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询消息中心 翻页
	 * 
	 * @author hslt
	 */
	public Pagination getNoticeContinue(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.selectNotice(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return pagination;
	}

	/**
	 * 企业用户登录首页 翻页
	 */
	public Pagination getNoticePage(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.noticeList(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	/**
	 * 用来判断风险页面是否发送过信息
	 * 
	 * @author hslt
	 */
	public List<GgNotice> forSeriesNo(GgNotice ggNotice) {
		List<GgNotice> list = null;
		try {
			list = ggNoticeMapper.forSeriesNo(ggNotice);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/**
	 * 信息“查询按钮”我接收的信息查询方法
	 * 
	 * @author hslt
	 */
	public List<Map<String, Object>> selectNotice(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.selectNotice(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> getNoticeUser(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggUserMapper.getNoticeUser(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<GgUser> selectNotice4User(GgUser user) {
		List<GgUser> list = null;
		try {
			list = ggUserMapper.selectNotice4User(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<GgNotice> selectRecipientDesc(String recipient) {
		List<GgNotice> list = null;
		try {
			list = ggUserMapper.selectRecipientDesc(recipient);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<GgUser> selectUserName(GgUser user) {
		List<GgUser> list = null;
		try {
			list = ggUserMapper.selectUserName(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Map<String, Object>> queryListSend(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggNoticeMapper.queryListSend(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
