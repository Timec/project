package com.chincook.notice;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chincook.notice.NoticeVO;
import com.core.exception.CmmException;

@Repository
public interface NoticeDAO {
	public List<Map<String, Object>> list(NoticeVO vo);
	
	public String total_cnt(NoticeVO vo);
	
	public int delete(String major, String minor);
	
	public Map<String, Object> edit(String major, String minor);
	
	public int update(NoticeVO vo) throws CmmException;
	
	public void insert(NoticeVO vo) throws CmmException;
}
