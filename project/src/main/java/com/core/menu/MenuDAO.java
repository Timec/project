package com.core.menu;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAO {
	public List<MenuVO> list(MenuVO menu) throws Exception;
}
