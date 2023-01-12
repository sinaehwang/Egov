package egovframework.example.service;

import java.util.List;

import egovframework.example.vo.EgoVo;

public interface EgovService {

	public List<EgoVo> selectTest(EgoVo egoVo) throws Exception;

	public EgoVo selectDetail(String name) throws Exception;

	/*
	 * @Resource private EgovDAO egovDAO;
	 * 
	 * public List<Map> getSemester(){
	 * 
	 * return egovDAO.getSemester(); }
	 */
	
 

	
}
