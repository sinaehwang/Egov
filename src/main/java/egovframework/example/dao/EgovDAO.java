package egovframework.example.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper("boardMapper")
public class EgovDAO {
	@Autowired
	@Resource(name="sqlSession")
	private SqlSession query;
	
	public List<Map> getSemester(){
		
		return query.selectList("getSemester");
	}
}
