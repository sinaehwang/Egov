package egovframework.example.service.impl;

import java.util.List;

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

}
