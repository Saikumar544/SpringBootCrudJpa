package com.example.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.entity.Hospital;

public class HospitalControllerTest {

	@Test
	public void testCreateHospital() {
		Hospital h=new Hospital();
		h.setHospitalName("apollo");
		h.setHospitalType("generic");
		h.setId(44);
		h.setLocation("hyderabad");
		
	}

	@Test
	public void testGetHospital() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteHospital() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateHospital() {
		fail("Not yet implemented");
	}

}
