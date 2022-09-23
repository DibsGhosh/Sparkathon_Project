package com.aro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aro.service.AppointmentService;
import com.aro.service.GWSService;
import com.aro.model.AppointmentData;
import com.aro.model.DoctorList;
import com.aro.model.Patient;

@RestController
public class AdminController {
	@Autowired
	private AppointmentService appService;
	
	@Autowired
	private GWSService gwsservice;
	
	@GetMapping("/admin/patient")
	public List<Patient> getPatient()
	{
		return gwsservice.getAllPatient();
		
	}
	
	@GetMapping("/admin/doctors")
	public List<DoctorList> getDoctor()
	{
		return gwsservice.getAllDoctor();
	}
	
	@GetMapping("/appointments")
	public List<AppointmentData> allAppointments(){
		return appService.getAllAppointment();
	}
	//Pending get
	
	
}
//
