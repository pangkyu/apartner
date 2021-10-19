package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.FacilityVO;
import org.zerock.domain.ReserveVO;
import org.zerock.service.ApartService;
import org.zerock.service.FacilityService;
import org.zerock.service.ReserveService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reserve/")
@Log4j
public class ReserveController {
	
	private final ApartService apartService;
	private final FacilityService facilityService;
	private final ReserveService reserveService;
	
	@GetMapping("/selectApart")
	public void viewApartList(Model model) {
		model.addAttribute("list", apartService.getList());
	}

	@GetMapping("/selectFac")
	public void facilityList(Model model, @RequestParam("apt_name") String apt_name) {
		model.addAttribute("faclist", facilityService.getList2(apt_name));
	}
	
	@GetMapping("/reserveFac")
	public void viewFacInfo(Model model, @RequestParam("fac_bno") Long fac_bno) {
		FacilityVO fac = facilityService.get(fac_bno);
		model.addAttribute("info", fac);
		String opentime= fac.getFac_opentime();
		String closetime = fac.getFac_closetime();
		String[] splitOpen = opentime.split(":");
		String[] splitClose = closetime.split(":");
		model.addAttribute("openmin", splitOpen[1]);
		model.addAttribute("openhour", splitOpen[0]);
		model.addAttribute("closemin", splitClose[1]);
		model.addAttribute("closehour", splitClose[0]);
	}
	
	@PostMapping("/reserve")
	public void reserveFacility(ReserveVO reserveVO) {
		reserveService.register(reserveVO);
	}
}
