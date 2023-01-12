package egovframework.example.service;

import java.util.List;

import egovframework.example.vo.EgoVo;

public interface TestMapper {
	
	List<EgoVo > selectTest(EgoVo egoVo) throws Exception;

	EgoVo selectDetail(String testName);
	

}
