package com.ankit.springmvcboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankit.springmvcboot.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

}

