package egovframework.example.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.dao.EgovDAO;
import egovframework.example.service.EgovService;
import egovframework.example.vo.EgoVo;

@Service
public class EgoServiceImpl implements EgovService{
	
	@Autowired
	private EgovDAO egoDao;
	
	@Override
	public List<EgoVo> selectTest(EgoVo egoVo) throws Exception {
		
		return egoDao.selectTest(egoVo);
	}
	
	@Override
	public EgoVo selectDetail(String name) throws Exception {
		
		return egoDao.selectDetail(name);
	}

	@Override
	public void doAdd(EgoVo egoVo) throws Exception {

		 egoDao.doAdd(egoVo);
	}

	@Override
	public EgoVo getArticle(int id) throws Exception {
		
		return egoDao.getArticle(id);
	}

	@Override
	public int getnewId() throws Exception{

		return egoDao.getnewId();
	}

	@Override
	public List<EgoVo> list(EgoVo egoVo) throws Exception {
		
		return egoDao.list(egoVo);
	}

	@Override
	public void delete(int id) throws Exception {

		egoDao.delete(id);
	}

	@Override
	public void doModify(Map<String,Object> egoVo) {
		
		 egoDao.doModify(egoVo);
		
	}

	@Override
	public int getLastId() {
		
		return egoDao.getLastId();
	}

}
