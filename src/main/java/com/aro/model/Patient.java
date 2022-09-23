package com.aro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
@Entity
@Table(name="patient")
public class Patient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	@NotBlank(message = "Patient Name cannot be Blank")
	@Column(name="patientName")
	private String patientName;
	

	@Min(value=1,message = "Patient age cannot be zero")
	@Column(name="patientAge")
	private int patientAge;
	
	
	@Size(min=10,max=10,message="Patient phone number should be 10 digit" )
    @Pattern(regexp="^[6-9]\\d{9}$", message="Patient phone number should start with 6/7/8/9")
	@Column(name="patientPhone")
	private String patientPhone;
	
	@NotBlank(message = "Patient address cannot be blank")
	@Column(name="patientAddress")
	private String patientAddress;

}
//
//