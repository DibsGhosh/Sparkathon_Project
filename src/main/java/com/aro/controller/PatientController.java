package com.aro.controller;

import java.sql.Date;

import java.time.LocalDate;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aro.service.AppointmentService;
import com.aro.service.GWSService;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.aro.model.AppointmentData;
import com.aro.model.DoctorList;
import com.aro.model.Patient;

@RestController

public class PatientController 
{
	@Autowired
	private GWSService gwsservice;
	
	@Autowired
	private AppointmentService appService;
	
	
	
	//adding patient details
		@PostMapping("/patient_register")
		public Patient addPatientById(@Valid@RequestBody Patient patient)
		{
			return gwsservice.addPatient(patient);
		}
		
	
	//get patient details by Patient ID	
	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable("id") int patientId)
	{
		return gwsservice.getPatientById(patientId);
	}
   
	
	//update patient details by Patient Id
	@PutMapping("/patient/{id}")
	public Patient updatePatient(@PathVariable("id") int patientId,@Valid @RequestBody Patient patient)
	{
		Patient p = gwsservice.getPatientById(patientId);
		//Patient p1=p.get();
		p.setPatientName(patient.getPatientName());
		p.setPatientAge(patient.getPatientAge());
		p.setPatientAddress(patient.getPatientAddress());
		p.setPatientPhone(patient.getPatientPhone());
		return gwsservice.updatePatient(p);
	}
	
	//fetching doctor details
	@GetMapping("/doctorlist")
	public List<DoctorList> getDoctorlist()
	{
		return gwsservice.getAllDoctor();
	}
   
	
	
    //book appointment 
	
	@PostMapping("/booking/{patientId}/{docId}/{appointDate}")
	public AppointmentData bookAppointment(@PathVariable int patientId,@PathVariable int docId, @Valid @PathVariable Date appointDate) {
		return appService.addAppointment(patientId, docId, appointDate);
	}
	
	@DeleteMapping("patient/delete/{patientId}")
	public void deletePatient(@PathVariable int patientId)
	{
		gwsservice.deletePatientById(patientId);
	}
	

	

}
//
