package com.core.menu;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService{

	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public List<MenuVO> list(String system, String user_id, String lang) throws Exception{
			MenuDAO mapper = session.getMapper(MenuDAO.class);
			
			return mapper.list(new MenuVO(system, user_id, lang));
	}
}
