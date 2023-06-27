package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j    // Simple Logging Facade for Java

public class MemberController {
	
	@Autowired
	private MemberService memberService;


	@RequestMapping("/member/list")
	public ModelAndView memberList() {

		ModelAndView mv=new ModelAndView("/member/list");
		List<MemberDTO> list=memberService.findMemberList();
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}

	@GetMapping("/member/ajax/list")
	public String memberAjaxList(Model model){
		List<MemberDTO> list=memberService.findMemberList();
		model.addAttribute("list",list);
		return "/index :: #listContainer";
	}
	
}