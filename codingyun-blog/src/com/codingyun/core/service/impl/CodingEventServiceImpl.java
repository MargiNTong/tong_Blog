package com.codingyun.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingyun.core.dao.GeneralDao;
import com.codingyun.core.entity.vo.AlipayEventUserVo;
import com.codingyun.core.service.CodingEventService;

@Service
public class CodingEventServiceImpl implements CodingEventService {
	
	@Autowired
	private GeneralDao generalDao;

	@Override
	public List<AlipayEventUserVo> getAlipayEventList() throws Exception {
		return generalDao.getEntityList(
				AlipayEventUserVo.class, 
				" SELECT *,(SELECT SUM(b.eventMoney) FROM coding_event_user b) AS totalMoney FROM coding_event_user a order by a.createTime", 
				new Object[]{});
	}

}
