package com.dsib.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dsib.common.Pagination;
import com.dsib.entity.GgUser;
import com.dsib.service.QyMycheckService;
@Controller
@RequestMapping("/myapply")
public class QyApplyController extends BaseController{

	@Resource(name="qymychecked")
	QyMycheckService  qymychecked;
	
	@RequestMapping("/myapplyInit")
	public  ModelAndView myapplyInit(){
		ModelAndView mad = new ModelAndView();
		GgUser ggUser = (GgUser) session.getAttribute("ggUser");
		Pagination pagination = new Pagination();
		Map<String,Object> condition = new HashMap<String, Object>();
		condition.put("insuredCode", ggUser.getUserCode());
		pagination.setQueryCondition(condition);
		List<Map<String,Object>> resultList = qymychecked.getApplyInit(pagination);
		Iterator it = resultList.iterator();
		while(it.hasNext()){
			Map<String,Object> iterMap= (Map<String, Object>) it.next();
			String special = String.valueOf(iterMap.get("SPECIALPROVISIONS"));
			if(special.length()>10){
				String newspecial = special.substring(10);
				iterMap.put("newspecial", newspecial);
			}else{
				iterMap.put("newspecial", special);
			}
			
			String advice = String.valueOf(iterMap.get("ADVISE"));
			if(advice.length()>10){
				String newadvice =advice.substring(10);
				iterMap.put("newadvice", newadvice);
			}else{
				iterMap.put("newadvice", advice);
			}
			}
		
		pagination.setResultList(resultList);
		mad.addObject(pagination);
		mad.setViewName("/qiye/myapply/myapplyResult");
		return mad;
	}
	
	@RequestMapping("/applyShow")
	public ModelAndView applyShow(){
		ModelAndView mad = new ModelAndView();
		//String business = request.
		mad.setViewName("/qiye/myapply/myapplyShow");
		return mad;
	}
}
