package com.aro.repo;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aro.model.AppointmentData;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentData, Integer>{

	//@Query("select * from appointmentdata where docId=?1")
	public List<AppointmentData> findAllByDocId(int docId);
	
	//prints only for value which is given one time in the table
	//public Optional<AppointmentData> findByDocId(int docId);
	
	//public List<AppointmentData> findAllByDocIdIn(int docId);
	
	
	
}//AppointmentRepo

//