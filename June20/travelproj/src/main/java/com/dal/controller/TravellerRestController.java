package com.dal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dal.entity.ForeignTour;
import com.dal.entity.LocalTour;
import com.dal.entity.Traveller;
import com.dal.repository.TravellerRepository;
import com.dal.service.TravellerService;

@RestController
public class TravellerRestController {

	@Autowired
	TravellerService travellerService;
	
	@Autowired
	TravellerRepository travellerRepository;

	@GetMapping("/welcome")
	public String hello() {
		return "Hi all";
	}

	@PostMapping("/addtraveller")
	public Traveller addTraveller(@RequestBody Traveller traveller) {

		return travellerService.addTraveller(traveller);
	}

	@GetMapping("/listalltraveller")
	public List<Traveller> listAllTravellers() {
		return travellerService.listAllTravellers();
	}
	@PreAuthorize("hasAuthority('DC')")
	@PostMapping("/requestlocaltour")
	public LocalTour saveLocalTourRequest(@RequestBody LocalTour localTour) {
		return travellerService.saveLocalTourRequest(localTour);
	}
	@PreAuthorize("hasAuthority('FC')")
	@PostMapping("/requestforeigntour")
	public ForeignTour saveForeignTourRequest(@RequestBody ForeignTour foreignTour) {
		System.out.println("****** From Controller Foreign ******" + foreignTour);
		return travellerService.saveForeignTourRequest(foreignTour);
	}
	
    @GetMapping("/listtour")	
	public String listTour() {
		return "Hi Welcome to Chennai";
	}
    @GetMapping("/login")	
	public ResponseEntity<Traveller> loginrest(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		System.out.println("*******This is a login rest controller ***********");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Traveller traveller = travellerRepository.findByTravellerName(auth.getName());
		System.out.println("After Login__________________"
				+ "send back to Angular or postman as response__________________" + traveller);
		return ResponseEntity.ok(traveller);
	}

}
