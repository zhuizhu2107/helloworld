package com.duan.controller.common.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.FlashMap;

import com.duan.controller.common.CommonController;

@Controller("commonController")
@RequestMapping(value = "/common")
public class CommonControllerImpl implements CommonController{

	private Log logger = LogFactory.getLog(this.getClass());

	@RequestMapping(value = "/removeSessionKey", method = RequestMethod.GET)
	@Override
	public void removeSessionKey(HttpServletRequest request, HttpServletResponse response, String key) {
		// TODO Auto-generated method stub
		logger.info("删除对应的SessionKey（"+key+"）");
		@SuppressWarnings("unchecked")
		List<FlashMap> list=(List<FlashMap>) request.getSession().getAttribute("org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS");
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				FlashMap map=list.get(i);
				if(map.get(key)!=null&&!"".equals(map.get(key))){
					list.remove(i);
				}
			}
			
			//重新给session复制
			request.getSession().setAttribute("org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS", list);
		}
	}
	
	
	
}
