package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.service.ApartService;
import org.zerock.service.FacilityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reserve/")
@Log4j
public class ReserveController {
	
	private final ApartService apartService;
	private final FacilityService facilityService;
	
	@GetMapping("/selectApart")
	public void viewApartList(Model model) {
		model.addAttribute("list", apartService.getList());
	}

	@GetMapping("/selectFac")
	public void facilityList(Model model, @RequestParam("apt_name") String apt_name) {
		model.addAttribute("faclist", facilityService.getList2(apt_name));
		System.out.println("타임 인덱스 찾기: "+facilityService.getList2(apt_name));
	}
	
	@GetMapping("/reserveFac")
	public void viewFacInfo(Model model, @RequestParam("fac_bno") Long fac_bno) {
		model.addAttribute("info", facilityService.get(fac_bno));
	}
}
