package com.aro.model;

import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name="doctorlist")
public class DoctorList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="docId")
	private int docId;
	
	@NotBlank(message = "Doctor Name Cannot be empty")
	@Column(name="docName")
	private String docName;
	
	
	@NotBlank(message = "Address cannot be empty")
	@Column(name="docAddress")
	private String docAddress;
	
	@Column(name="docTiming")
	private String docTiming;
	
	@NotBlank(message = "Doctor Department cannot be empty")
	@Column(name="docDepartment")
	private String docDepartment;

	
	@NotNull
	@Min(value = 1, message = "fees value cannot be zero or less")
	@Column(name="docFees")
	private float docFees;
	
	@NotBlank(message = "Doctor Qualification cannot be empty")
	@Column(name="docQualification")
	private String docQualification;
	
	@NotNull
	@Min(value=1, message = "Doctor experience cannot be zero")
	@Column(name="docExperience")
	private int docExperience;
	//
	
	@SuppressWarnings("deprecation")
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08s\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	@Column(name="docMail")
	private String docMail;
	
}
//
