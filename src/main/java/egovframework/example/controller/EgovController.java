package egovframework.example.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.service.EgovService;

@Controller
public class EgovController {
	
	@Resource(name="egovService")
	private EgovService egovService;
	
	@RequestMapping("/view.do")
	public ModelAndView dbPage(ModelAndView mav) throws Exception{
		
		List<Map> semesterModel = egovService.getSemester(); 
		
		mav.addObject("semester", semesterModel);
		mav.setViewName("view");
		
		return mav;
	}
}
