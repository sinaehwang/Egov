package egovframework.example.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.dao.EgovDAO;
import egovframework.example.service.TestMapper;
import egovframework.example.vo.EgoVo;

@Repository
public class EgoDaoImpl implements EgovDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EgoVo> selectTest(EgoVo egoVo) throws Exception{
		
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		return mapper.selectTest(egoVo);
	}
	
	@Override
	public EgoVo selectDetail(int testId) throws Exception{
		
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		return mapper.selectDetail(testId);
	}
	
	

}
