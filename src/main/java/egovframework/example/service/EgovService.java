package egovframework.example.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.dao.EgovDAO;

@Service
public class EgovService {
	@Resource
	private EgovDAO egovDAO;
	
	public List<Map> getSemester(){
		
		return egovDAO.getSemester();
	}
}
