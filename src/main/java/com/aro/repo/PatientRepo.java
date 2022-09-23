package com.aro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aro.model.Patient;

@Repository
@EnableJpaRepositories
public interface PatientRepo extends JpaRepository<Patient, Integer>
{
	@Query
	public Patient findByPatientIdOrPatientPhone(int patientId, String patientPhone);
	
	
	
	
}
//