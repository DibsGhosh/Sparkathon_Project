package com.aro.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aro.service.AppointmentService;
import com.aro.service.DoctorService;
import com.aro.service.GWSService;
import com.aro.model.AppointmentData;
import com.aro.model.DoctorList;
import com.aro.model.Patient;


@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorservice;
	
	@Autowired
	private GWSService gwsservice;
	
	@Autowired
	private AppointmentService appoint;
	
	
	//adding doctor details

			@PostMapping("/doctor_register")
			public DoctorList addDoctorById(@Valid @RequestBody DoctorList doctorlist)
			{
				return doctorservice.addDoctor(doctorlist);
			}
	
			
	//fetching doctor details by Doctor Id		

	@GetMapping("/doctor/{id}")
	public DoctorList getDoctorById(@PathVariable("id") int docId)
	{
		return doctorservice.getDoctorById(docId);
	}

	
    //update doctor details by Doctor ID
	@PutMapping("/doctor/{id}")
	public DoctorList updateDoctor(@PathVariable("id") int docId, @Valid @RequestBody DoctorList doctorList)
	{
		DoctorList d = doctorservice.getDoctorById(docId);
		d.setDocName(doctorList.getDocName());
		d.setDocAddress(doctorList.getDocAddress());
		d.setDocTiming(doctorList.getDocTiming());
		d.setDocDepartment(doctorList.getDocDepartment());
		d.setDocFees(doctorList.getDocFees());
		d.setDocQualification(doctorList.getDocQualification());
		d.setDocExperience(doctorList.getDocExperience());
		d.setDocMail(doctorList.getDocMail());
			
		return doctorservice.updateDoctor(d);
	}
		
	
	//doctor fetching his appointment details
	@GetMapping("/doctor/appointmentdata/{id}")
	public List<AppointmentData> getAppointmentDataById(@PathVariable("id") int docId)
	{
		return appoint.getAppointmentDataById(docId);
	}

	@DeleteMapping("doctor/delete/{docId}")
	public void deleteDoctor(@PathVariable int docId)
	{
		doctorservice.deleteDoctorById(docId);
	}
}

