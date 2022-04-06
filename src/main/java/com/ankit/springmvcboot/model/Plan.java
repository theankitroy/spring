package com.ankit.springmvcboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="plans")
public class Plan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pid;
	
	@Column(name = "plan_name")
	private String pname;
	
	@Column(name = "plan_price")
	private int pprice;
	
	@Column(name="plan_offer")
	private String poffer;
	
	@Column(name="plan_validity")
	private int pvalidity;
	
	@Column(name="plan_desc")
	private String pdesc;
	
	public Plan() {
		
	}
	
	

	public Plan(Long pid, String pname, int pprice, String offer, int pvalidity, String pdesc) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.poffer = offer;
		this.pvalidity = pvalidity;
		this.pdesc = pdesc;
	}



	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getOffer() {
		return poffer;
	}

	public void setOffer(String offer) {
		this.poffer = offer;
	}

	public int getPvalidity() {
		return pvalidity;
	}

	public void setPvalidity(int pvalidity) {
		this.pvalidity = pvalidity;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	

}
