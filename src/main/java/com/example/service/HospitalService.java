package com.example.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Hospital;
import com.example.repository.HospitalRepository;

@Service
@Transactional
public class HospitalService {
	Logger log = LoggerFactory.getLogger(HospitalService.class);
	@Autowired
	private HospitalRepository repository;

	public Hospital addHospital(Hospital hospital) {
		log.info("entered into add");
		return repository.save(hospital);
	}

	public Optional<Hospital> getHospitalById(int id) {
		log.info("entered into get()");
		return repository.findById(id);
	}

	public Hospital updateHospital(Hospital hospital) {
		log.info("entered into update()");
		Hospital updatedHospital = repository.saveAndFlush(hospital);
		return updatedHospital;
	}

	public int deleteHospital(int id) {
		log.info("entered into delete");
		repository.deleteById(id);
		return id;
	}
}
