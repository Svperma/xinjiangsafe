package com.dsib.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsib.common.Pagination;
import com.dsib.dao.GgSubscribeMapper;
import com.dsib.dao.GovOrganMapper;
import com.dsib.entity.GgSubscribe;
import com.dsib.entity.GovOrgan;
import com.dsib.service.GovOrganService;

@Service("govOrganService")
public class GovOrganServiceImpl implements GovOrganService {
	@Autowired
	private GovOrganMapper govOrganMapper;
	@Autowired
	private GgSubscribeMapper ggSubscribeMapper;

	public <T> T getObjectById() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author hslt
	 */
	public void insertGov(GovOrgan govOrgan) {
		try {
			govOrganMapper.insertGov(govOrgan);
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return;
	}

	public List<GovOrgan> getGovOrganBy_OrgCode(Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GovOrgan> selectGovorgan4Code(GovOrgan govOrgan) {
		List<GovOrgan> list = null;
		try {
			list = govOrganMapper.selectGovorgan4Code(govOrgan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<GovOrgan> selectGovorganEvaPersons(GovOrgan govOrgan) {
		List<GovOrgan> list = null;
		try {
			list = govOrganMapper.selectGovorganEvaPersons(govOrgan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<Map<String, Object>> addInveStigateByOrgan(Pagination map) {
		List<Map<String, Object>> list = null;
		try {
			list = govOrganMapper.addInveStigateByOrgan(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<GovOrgan> selectGovorganByCode(GovOrgan govOrgan) {
		List<GovOrgan> list = null;
		try {
			list = govOrganMapper.selectGovorganByCode(govOrgan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<GgSubscribe> selectSubscribe(GgSubscribe sub) {
		List<GgSubscribe> list = null;
		try {
			list = ggSubscribeMapper.selectSubscribe(sub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<GovOrgan> selectiveGovOrgan(GovOrgan govOrgan) {
		return govOrganMapper.selectiveGovOrgan(govOrgan);
		 
	}

	@Override
	public void insertGovOrganSelective(GovOrgan govOrgan) {
		govOrganMapper.insertGovOrganSelective(govOrgan);
	}

	@Override
	public void updateGovOrganSelective(GovOrgan govOrgan) {
		govOrganMapper.updateGovOrganSelective(govOrgan);
	}

}
