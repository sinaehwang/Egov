package egovframework.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.service.EgovService;
import egovframework.example.util.Ut;
import egovframework.example.vo.EgoVo;

@Controller
public class EgovController {

	@Autowired
	private EgovService egovService;

	@RequestMapping(value = "/main.do")
	public String main() throws Exception {

		return "saminForest";
	}

	@RequestMapping(value = "/write.do")
	public String write() throws Exception {

		return "insertBoard";
	}

	@RequestMapping(value = "/doAdd.do")
	public String doAdd(@ModelAttribute("egoVo") EgoVo egoVo, HttpServletRequest request) throws Exception {

		egovService.doAdd(egoVo);

		int id = egovService.getLastId();

		return "redirect:detail.do?id=" + id;
	}

	@RequestMapping(value = "/delete.do")
	public String delete(HttpServletRequest request) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));

		egovService.delete(id);

		return "redirect:main.do";

	}

	@RequestMapping(value = "/list.do")
	public String list(Model model, EgoVo egoVo) throws Exception {

		model.addAttribute("list", egovService.list(egoVo));

		return "list";

	}

	@RequestMapping(value = "/detail.do")
	public String detail(Model model, HttpServletRequest request) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));

		EgoVo article = egovService.getArticle(id);

		model.addAttribute("article", article);

		return "detailBoard";

	}

	@RequestMapping(value = "/modify.do")
	public String modify(Model model, HttpServletRequest request) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));

		EgoVo article = egovService.getArticle(id);

		model.addAttribute("updateCheck", request.getParameter("updateCheck"));

		model.addAttribute("article", article);

		return "passwordPopup";
	}

	@RequestMapping(value = "/docheckPw.do")
	public String doCheck(@RequestParam Map<String, Object> param,  Model model,HttpServletRequest request)
			throws Exception {

		String pw = request.getParameter("pw");

		int id = Integer.parseInt(request.getParameter("board_id"));

		EgoVo article = egovService.getArticle(id);
		
		if(article.getPassword().equals(pw)==false) {
			
			request.setAttribute("msg", "??????????????? ???????????? ????????????.");
			request.setAttribute("url", "/Egov/detail.do?id="+id);

			return "alert";
		}
		
		model.addAttribute("article", article);

		return "modify";

	}

	@RequestMapping(value = "/doModify.do")
	public String doModify(@RequestParam Map<String, Object> param) throws Exception {

		egovService.doModify(param);

		return "redirect:detail.do?id=" + param.get("board_id");

	}

	@RequestMapping(value = "testDetail.do")
	public String viewForm(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String name = request.getParameter("testName");

		// ????????? ????????? ????????? ???????????? ?????? ?????????
		if (name.isEmpty()) {
			request.setAttribute("msg", "????????? ??????????????????");
			request.setAttribute("url", "/Egov/testList.do");

			return "alert";
		}

		// ????????? ???????????? ?????? ???????????? ???????????????
		if (Ut.isStandardLoginIdString(name)) {
			request.setAttribute("msg", "????????? ????????? ??? ????????????.");
			request.setAttribute("url", "/Egov/testList.do");

			return "alert";

			// return Ut.msgAndBack(request, "????????? ????????? ??? ????????????.");
		}

		EgoVo egoVo = egovService.selectDetail(name);

		if (egoVo == null) {

			request.setAttribute("msg", "???????????? ??????????????? ????????????.");
			request.setAttribute("url", "/Egov/testList.do");

			// return Ut.msgAndBack(request, "???????????? ??????????????? ????????????.");

			return "alert";
		}

		model.addAttribute("vo", egoVo);

		return "testDetail";

	}

	@RequestMapping(value = "/testList.do")
	public String testListdo(EgoVo egoVo, Model model) throws Exception {

		model.addAttribute("list", egovService.selectTest(egoVo));

		return "view";

	}

}
