package egovframework.example.service;

import java.util.List;
import java.util.Map;

import egovframework.example.vo.EgoVo;

public interface EgovService {

	public List<EgoVo> selectTest(EgoVo egoVo) throws Exception;

	public EgoVo selectDetail(String name) throws Exception;

	public void doAdd(EgoVo egoVo) throws Exception;

	public EgoVo getArticle(int id) throws Exception;

	public int getnewId() throws Exception;

	public List<EgoVo> list(EgoVo egoVo) throws Exception;

	public void delete(int id) throws Exception;

	public void doModify(Map<String,Object> param);

	public int getLastId();

	
 

	
}
