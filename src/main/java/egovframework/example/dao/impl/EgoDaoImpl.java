package egovframework.example.dao.impl;

import java.util.List;
import java.util.Map;

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
	public EgoVo selectDetail(String name) throws Exception{
		
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		return mapper.selectDetail(name);
	}

	@Override
	public void doAdd(EgoVo egoVo) {

		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		 mapper.doAdd(egoVo);
	}

	@Override
	public EgoVo getArticle(int id) {

		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		return mapper.getArticle(id);
	}

	@Override
	public int getnewId() throws Exception {
		
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);

		return mapper.getnewId();
	}

	@Override
	public List<EgoVo> list(EgoVo egoVo) throws Exception {

		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		return mapper.list(egoVo);
	}

	@Override
	public void delete(int id) {
		
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		mapper.delete(id);
	}

	@Override
	public void doModify(Map<String,Object> egoVo) {
		
		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		 mapper.doModify(egoVo);
		
	}

	@Override
	public int getLastId() {

		TestMapper mapper = sqlSession.getMapper(TestMapper.class);
		
		return mapper.getLastId();
	}
	
	

}
