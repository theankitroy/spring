package com.ankit.springmvcboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import antlr.collections.List;
import java.util.*;

import com.ankit.springmvcboot.exception.ResourceNotFoundException;
import com.ankit.springmvcboot.model.Plan;
import com.ankit.springmvcboot.repository.PlanRepository;
//import com.ankit.springmvcboot.controller.

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins="http://localhost:4200")
public class PlanController {
	
	@Autowired
	private PlanRepository planRepository;
	
	@GetMapping("/allPlans")
	public java.util.List<Plan> getAllPlans(){
		return  planRepository.findAll();
	}
	
	@PostMapping("/addPlans")
	public Plan createPlan(@RequestBody Plan plan) {
		return planRepository.save(plan);
	}
	
	//Get plans by id
	@GetMapping("/{id}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Long id){
		Plan plan=planRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Plan doesn't exist with this id: "+id));
		return ResponseEntity.ok(plan);
	}
	
	//Updating the plan list
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<Plan> updatePlan(@PathVariable Long id,@RequestBody Plan planDetails){
		Plan plan=planRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Plan doesn't exist with this id: "+id));
		
		plan.setPname(planDetails.getPname());
		plan.setPprice(planDetails.getPprice());
		plan.setOffer(planDetails.getOffer());
		plan.setPvalidity(planDetails.getPvalidity());
		plan.setPdesc(planDetails.getPdesc());
		
		Plan updatePlan=planRepository.save(plan);
		return ResponseEntity.ok(updatePlan);
	}
	
}