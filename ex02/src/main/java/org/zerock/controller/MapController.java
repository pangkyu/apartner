package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ApartVO;
import org.zerock.domain.FacilityVO;
import org.zerock.service.ApartService;
import org.zerock.service.FacilityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/map/")
@Log4j
public class MapController {
	
	private final ApartService apartService;
	private final FacilityService facilityService;
	
	@GetMapping("/viewMap")
	public void viewMap() {
		
	}
	
	@GetMapping("/viewApartList")
	public void viewApartList(Model model) {
		model.addAttribute("list", apartService.getList());
	}
	
	@GetMapping("/facilityList")
	public void facilityList(Model model) {
		model.addAttribute("faclist", facilityService.getList());
	}
	
	@GetMapping("/registerFac")
	public void registerFac(Model model, @RequestParam("apt_name")String apt_name, @RequestParam("apt_bno")Long apt_bno) {
		
		model.addAttribute("apt_name",apt_name);
		model.addAttribute("getApart", apartService.get(apt_bno));
	}

	@PostMapping("/registerApart")
	public String registerApart(ApartVO apartVO, RedirectAttributes rttr) {
				
		apartService.register(apartVO);
		return "redirect:/map/viewApartList";
	}
	
	@PostMapping("/registerFacility")
	public String registerFacility(FacilityVO facilityVO, RedirectAttributes rttr) {
		facilityService.register(facilityVO);
		
		return "redirect:/map/facilityList";
	}
}
