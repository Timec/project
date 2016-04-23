package com.chincook.notice;

import com.chincook.notice.NoticeVO;
import com.core.exception.CmmException;

public interface NoticeService{
	public NoticeVO list(NoticeVO vo) throws CmmException;
	
	public int delete(NoticeVO vo) throws CmmException;
	
	public NoticeVO edit(NoticeVO vo) throws CmmException; 
	
	public void update(NoticeVO vo) throws CmmException;
	
	public void insert(NoticeVO vo) throws CmmException;
}
