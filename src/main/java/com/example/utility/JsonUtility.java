package com.example.utility;

import com.example.entity.Hospital;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {
public static void main(String[] args) throws JsonProcessingException {
	ObjectMapper ob=new ObjectMapper();
	Hospital h=new Hospital();
	h.setHospitalName("apollo");
	h.setHospitalType("ortho");
	h.setId(10);
	h.setLocation("cyber towers");
	String hospitalJson = ob.writeValueAsString(h);
	System.out.println(hospitalJson);
}
}
