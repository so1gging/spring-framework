package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

//해당 클래스가 Dao임을 알리는 어노테이션
@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
		list = sqlSession.selectList(NAMESPACE+"selectList");
		}catch (Exception e) {
			System.out.println("[error] : selectList");
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
