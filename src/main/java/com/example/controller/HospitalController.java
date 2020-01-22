package com.example.controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Hospital;
import com.example.exception.ApiHandling;
import com.example.exception.HospitalNotFoundException;
import com.example.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	Logger log = LoggerFactory.getLogger(HospitalController.class);
	@Autowired
	private HospitalService hospitalService;

	@PostMapping("/")
	public Hospital createHospital(@RequestBody @Valid Hospital hospital) {
		log.info("entered into createHospital() ");
		return hospitalService.addHospital(hospital);
	}

	@GetMapping("/{id}")
	public Optional<Hospital> getHospital(@PathVariable int id) {
		log.info("entered into getHospital() ");
		Optional<Hospital> hospital = null;
		hospital = hospitalService.getHospitalById(id);
		if (hospital.isPresent()) {
			return hospital;
		} else {

			throw new ApiHandling(new Date()," hospital not found : "+id);
		}

		/*
		 * Optional<Hospital> hospital = null; try { hospital =
		 * hospitalService.getHospitalById(id); if ( hospital!= null) { return hospital;
		 * } else { throw new HospitalNotFoundException("no hospital found : " + id); }
		 * } catch (HospitalNotFoundException he) { log.error("hospital with id : "+id
		 * +" not found "); } return hospital;
		 */

		/*
		 * if (hospitalService.getHospitalById(id) == null) { log.error("not found " +
		 * id); throw new HospitalNotFoundException("hospital not found : " + id); }
		 * else { log.info("exited  from getHospital() "); return
		 * hospitalService.getHospitalById(id); }
		 */
	}

	@DeleteMapping("/{id}")
	public int deleteHospital(@PathVariable int id) {
		log.info("entered into delete() ");
		if (hospitalService.getHospitalById(id) == null) {
			throw new HospitalNotFoundException("hospital not found : " + id);
		} else {
			log.info("exited from into getHospital() ");
			return hospitalService.deleteHospital(id);
		}

	}

	@PutMapping("/")
	public Hospital updateHospital(@RequestBody Hospital hospital) {
		log.info("entered into updateHospital() ");
		if (hospitalService.getHospitalById(hospital.getId()) == null)
			throw new HospitalNotFoundException("hospital not found : " + hospital.getId());
		log.info("exited from updateHospital() ");
		return hospitalService.updateHospital(hospital);

	}
}