package egovframework.example.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.service.EgovService;
import egovframework.example.vo.EgoVo;

@Controller
public class EgovController {
	
	
	@Autowired
	private EgovService egovService;

	/*
	 * @RequestMapping("/view.do") public ModelAndView dbPage(ModelAndView mav)
	 * throws Exception{
	 * 
	 * List<Map> semesterModel = egovService.getSemester();
	 * 
	 * mav.addObject("semester", semesterModel); mav.setViewName("view");
	 * 
	 * return mav; }
	 */
	
	
	@RequestMapping(value="/testList.do")
	public String testListdo(EgoVo egoVo,Model model) throws Exception {
		
	
		model.addAttribute("list", egovService.selectTest(egoVo));
		
		return "view";
		
		
	}
	
	@RequestMapping(value = "testDetail.do")
	public String viewForm(Model model, HttpServletRequest request) throws Exception{
		
		int testId = Integer.parseInt(request.getParameter("testId"));
		
		EgoVo egoVo = egovService.selectDetail(testId);
		
		model.addAttribute("vo", egoVo);
		
		return "testDetail";
		
	}
	
	

	
	
}
