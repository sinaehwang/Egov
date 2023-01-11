package egovframework.example.dao;

import java.util.List;

import egovframework.example.vo.EgoVo;

public interface EgovDAO {

	List<EgoVo> selectTest(EgoVo egoVo) throws Exception;

	EgoVo selectDetail(int testId) throws Exception;

}
