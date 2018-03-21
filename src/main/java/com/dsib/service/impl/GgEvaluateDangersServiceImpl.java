package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.ConditionAdapter;
import com.dsib.common.Pagination;
import com.dsib.dao.GgEvaluateDangersMapper;
import com.dsib.dao.GgSubscribeMapper;
import com.dsib.entity.GGovexpert;
import com.dsib.entity.GgEvaluateDangers;
import com.dsib.entity.GgUserCorp;
import com.dsib.service.GgEvaluateDangersService;

@Service("ggEvaluateDangersService")
public class GgEvaluateDangersServiceImpl implements GgEvaluateDangersService {
	@Autowired
	private GgEvaluateDangersMapper ggEvaluateDangersMapper;
	@Autowired
	private GgSubscribeMapper ggSubscribeMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * husiletu 分页查询企业评估列表
	 */
	public List<Map<String, Object>> getUserCorpInfo(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.getUserCorpInfo(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * husiletu 评估内容查看
	 */
	public List<Map<String, Object>> getCorpBy_userCode(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.getCorpBy_userCode(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * husiletu 分页查询未评估企业列表
	 */
	public List<Map<String, Object>> selectdangerSourceNotDetails(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.selectdangerSourceNotDetails(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询未评估机构
	 * 
	 * @author hslt
	 * 
	 */
	public List<Map<String, Object>> selectGovOrganDetails(String classCode) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.selectGovOrganDetails(classCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> selectGovOrganPersons(GGovexpert govExpert) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.selectGovOrganPersons(govExpert);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * husiletu 未评估企业列表确认
	 */
	public List<Map<String, Object>> getDangerSourceDetails(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.getDangerSourceDetails(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 保存企业信息
	 * 
	 * @author hslt
	 * @param ggusercorp
	 * @return
	 */
	public void updateUserCorp(GgUserCorp ggusercorp) {
		try {
			ggEvaluateDangersMapper.updateUserCorp(ggusercorp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 保存评估危险源信息
	 * 
	 * @author hslt
	 */
	public void insertEvaDanger(GgEvaluateDangers ggEvaluateDangers) {
		try {
			ggEvaluateDangersMapper.insertEvaDanger(ggEvaluateDangers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 更新评估危险源信息
	 * 
	 * @author hslt
	 */
	public void updateEvaDanger(GgEvaluateDangers ggEvaluateDangers) {
		try {
			ggEvaluateDangersMapper.updateEvaDanger(ggEvaluateDangers);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 查询机构等级
	 * 
	 * @author hslt
	 */
	public String getGrage(String stringGrage) {
		String list = null;
		try {
			list = ggEvaluateDangersMapper.getGrage(stringGrage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 下载报表
	 * 
	 * @author hslt
	 */
	public List<Map<String, Object>> getUserCorpToExc(ConditionAdapter adapter) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.getUserCorpToExc(adapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Pagination getRiskLevel(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.getUserCorpInfo(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	public Pagination getUsercorpContinue(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper
					.selectdangerSourceNotDetails(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	public List<Map<String, Object>> whetherList(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggEvaluateDangersMapper.whetherList(map);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> selectCheckWrite(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggSubscribeMapper.selectCheckWrite(map);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return list;
	}

	public List<GgEvaluateDangers> selectCheckDetails(GgEvaluateDangers eva) {
		List<GgEvaluateDangers> list = null;
		try {
			list = ggSubscribeMapper.selectCheckDetails(eva);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Map<String, Object>> selectChecking(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggSubscribeMapper.selectChecking(map);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return list;
	}

	public void insertEvaDangerChecking(GgEvaluateDangers ggEvaluateDangers) {
		try {
			ggSubscribeMapper.insertEvaDangerChecking(ggEvaluateDangers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public List<GgEvaluateDangers> selectEva(Pagination map) {
		List<GgEvaluateDangers> list = null;
		try {
			list = ggSubscribeMapper.selectEva(map);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * public List<Map<String, Object>> selectEva(Pagination map) {
	 * List<Map<String, Object>> list = null; try { list =
	 * ggSubscribeMapper.selectEva(map); } catch (Exception e) { // TODO
	 * Auto-generated method stub e.printStackTrace(); } return list; }
	 */

	public void updateEvaStatus(GgEvaluateDangers ggEvaluateDangers) {
		try {
			ggSubscribeMapper.updateEvaStatus(ggEvaluateDangers);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return;
	}

	public void insertEvaStatus(GgEvaluateDangers ggEvaluateDangers) {
		try {
			ggSubscribeMapper.insertEvaStatus(ggEvaluateDangers);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return;
	}

	public Pagination CheckingContinue(Pagination pagination) {
		List<Map<String, Object>> list = null;
		try {
			list = ggSubscribeMapper.selectChecking(pagination);
			pagination.setResultList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagination;
	}

	public List<Map<String, Object>> selectEvaChecking(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = ggSubscribeMapper.selectEvaChecking(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insertGgEvaluateDangersBySelective(
			GgEvaluateDangers evaluateDangers) {
		ggEvaluateDangersMapper.insertGgEvaluateDangersBySelective(evaluateDangers);
	}

	@Override
	public List<GgEvaluateDangers> selectiveEvaluateDangers(
			GgEvaluateDangers evaluateDanagers) {
		return ggEvaluateDangersMapper.selectiveEvaluateDangers(evaluateDanagers);
	}

	@Override
	public void updateEvaDangerSelective(GgEvaluateDangers evaluateDanagers) {
		ggEvaluateDangersMapper.updateEvaDangerSelective(evaluateDanagers);
	}

}
