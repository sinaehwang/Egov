package egovframework.example.service;

import java.util.List;
import java.util.Map;

import egovframework.example.vo.EgoVo;

public interface TestMapper {
	
	List<EgoVo > selectTest(EgoVo egoVo) throws Exception;

	EgoVo selectDetail(String testName);

	void doAdd(EgoVo egoVo);

	EgoVo getArticle(int id);

	int getnewId();

	List<EgoVo> list(EgoVo egoVo);

	void delete(int id);

	void doModify(Map<String,Object> egoVo);

	int getLastId();
	

}
