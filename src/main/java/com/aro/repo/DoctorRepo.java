package com.aro.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.aro.model.DoctorList;


@Repository
public interface DoctorRepo extends JpaRepository<DoctorList, Integer>{
	
	public DoctorList findByDocIdOrDocMail(int docId, String docMail);
	

}
//