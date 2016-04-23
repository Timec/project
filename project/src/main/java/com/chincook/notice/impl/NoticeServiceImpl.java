package com.chincook.notice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chincook.notice.NoticeDAO;
import com.chincook.notice.NoticeService;
import com.chincook.notice.NoticeVO;
import com.core.common.CmmMessageUtil;
import com.core.exception.CmmException;
import com.core.util.CmmBeanUtils;
import com.core.util.CmmUserUtil;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public NoticeVO list(NoticeVO vo) throws CmmException{
		try{
			NoticeDAO mapper = session.getMapper(NoticeDAO.class);
		    
			vo.setList(mapper.list(vo));
//			vo.setTotal_cnt(mapper.total_cnt(vo));
			
			return vo;
		}catch(DataAccessException e){
			throw CmmMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw CmmMessageUtil.getError(e);
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public int delete(NoticeVO vo) throws CmmException {
		try{
			NoticeDAO mapper = session.getMapper(NoticeDAO.class);
			
			CmmUserUtil.setDefaultUserInfo(vo);
			
//			String[] major = (String[]) vo.getHd_major_cd();
//			String[] minor = (String[]) vo.getHd_minor_cd();
			
			int cnt = 0;
			
//			for(int i=0;i<major.length;i++){
//				cnt += mapper.delete(major[i], minor[i]);
//			}
			
			return cnt;
		}catch(DataAccessException e){
			throw CmmMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw CmmMessageUtil.getError(e);
		}
		
	}

	@Override
	public NoticeVO edit(NoticeVO vo) throws CmmException {
		try{
			NoticeDAO mapper = session.getMapper(NoticeDAO.class);
			Map<String, Object> resultMap = mapper.edit(vo.getBbs_id(), vo.getCn_id());
		    
			CmmBeanUtils.populate(vo, resultMap);
			
			return vo;
		}catch(DataAccessException e){
			throw CmmMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw CmmMessageUtil.getError(e);
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void update(NoticeVO vo) throws CmmException {
		try{
			NoticeDAO mapper = session.getMapper(NoticeDAO.class);
			
//			CmmUserUtil.setDefaultUserInfo(vo);
			
			int result = mapper.update(vo);
		    
			if(0 == result){
				throw CmmMessageUtil.getError("db.sql.update_fail");				
			}
		}catch(DataAccessException e){
			throw CmmMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw CmmMessageUtil.getError(e);
		}
	}

	@Override
	@Transactional
	public void insert(NoticeVO vo) throws CmmException {
		try{
			NoticeDAO mapper = session.getMapper(NoticeDAO.class);
			
//			CmmUserUtil.setDefaultUserInfo(vo);
			
			mapper.insert(vo);
		    
		}catch(DataAccessException e){
			throw CmmMessageUtil.getError(e);
		}catch(ClassCastException e){
			throw CmmMessageUtil.getError(e);
		}
	}
}
