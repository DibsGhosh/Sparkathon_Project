package com.aro.service;



import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.DeleteMapping;

import com.aro.exception.DoctorNotFoundException;

import com.aro.exception.DuplicatePatientDetailslException;

import com.aro.exception.PatientNotFoundException;

import com.aro.model.AppointmentData;

import com.aro.model.DoctorList;

import com.aro.model.Patient;

import com.aro.repo.AppointmentRepo;

import com.aro.repo.DoctorRepo;

import com.aro.repo.PatientRepo;

@Service

public class AppointmentService {

@Autowired

private AppointmentRepo appoint;

@Autowired

private DoctorRepo doctorrepo;

@Autowired

private PatientRepo patientrepo;

//get All Appointment

public List<AppointmentData> getAllAppointment(){

 return appoint.findAll();

}

//save appointment

public AppointmentData addAppointment(int patientId,int docId,Date appointDate) {

 Optional<Patient> patient = patientrepo.findById(patientId);

 Optional<DoctorList> doctor= doctorrepo.findById(docId);

 if(patient.isPresent() && doctor.isPresent())
 {
	 List<AppointmentData> list=appoint.findAll();

	 for(AppointmentData l :list) 
	 {
		 if(l.getAppointDate().compareTo(appointDate)==0 && l.getDocId()==docId && l.getPatientId()==patientId) 
		 {
			 throw new DuplicatePatientDetailslException("Booking already done");
		 }

 }

 Patient p=patient.get();

 DoctorList d=doctor.get();

 AppointmentData updatedAppointmentData=new AppointmentData();

 updatedAppointmentData.setDocId(docId);

 updatedAppointmentData.setDocFees(d.getDocFees());

 updatedAppointmentData.setDocName(d.getDocName());

 updatedAppointmentData.setPatientId(p.getPatientId());

 updatedAppointmentData.setPatientName(p.getPatientName());

 updatedAppointmentData.setAppointDate(appointDate);

 return appoint.save(updatedAppointmentData);

 }

 else if(patient.isPresent())

 {

 throw new PatientNotFoundException("Doctor id is invalid");//Error

 }

 else if(doctor.isPresent()) {//Doctor valid

 throw new PatientNotFoundException("Patient id is invalid");

 }

 else {

 throw new PatientNotFoundException("Patient id and Doctor id is invalid");

 }

}

public List<AppointmentData> getAppointmentDataById(int docId)

{

 List<AppointmentData> doctor = appoint.findAllByDocId(docId);

 if(doctor.listIterator().hasNext())

 {

 return appoint.findAllByDocId(docId);

 }

 else

 {

 throw new DoctorNotFoundException("No appointments scheduled for this Doctor");

 }

}

}

//































