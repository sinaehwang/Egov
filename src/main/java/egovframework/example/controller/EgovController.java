package egovframework.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.service.EgovService;
import egovframework.example.util.Ut;
import egovframework.example.vo.EgoVo;

@Controller
public class EgovController {
	
	
	@Autowired
	private EgovService egovService;

	
	
	@RequestMapping(value="/testList.do")
	public String testListdo(EgoVo egoVo,Model model) throws Exception {
	
		model.addAttribute("list", egovService.selectTest(egoVo));
		
		return "view";
		
		
	}
	
	@RequestMapping(value = "testDetail.do")
	public String viewForm(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String name = request.getParameter("testName");
		
		//이름이 공백인 경우를 막기위한 임시 데이터
		if(name.isEmpty()) {
			request.setAttribute("msg", "이름을 입력해주세요");
			request.setAttribute("url", "/Egov/testList.do");
			
			return "alert";
		}
		
		//숫자로 시작하는 경우 막기위한 임시데이터
		if(Ut.isStandardLoginIdString(name)) {
			request.setAttribute("msg", "숫자로 시작할 수 없습니다.");
			request.setAttribute("url", "/Egov/testList.do");
			
			return "alert";
			
			//return Ut.msgAndBack(request, "숫자로 시작할 수 없습니다.");
		}
		
		
		EgoVo egoVo = egovService.selectDetail(name);
		
		
		if(egoVo==null) {
			
			request.setAttribute("msg", "일치하는 회원정보가 없습니다.");
			request.setAttribute("url", "/Egov/testList.do");
			
			//return Ut.msgAndBack(request, "일치하는 회원정보가 없습니다.");
			
			return "alert";
		}
		
		model.addAttribute("vo", egoVo);
		
		return "testDetail";
		
	}
	
	

	
	
}
