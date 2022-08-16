package com.verifone.springbootverifone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "SimCardNo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sim_card_no {

	@Id
	@Column(name="mobile_No")
	private long mobile_No;
	@Column(name="status")
	private String status;
	@Column(name="expiry_date")
	private Timestamp expiry_date;
	@Column(name="state_of_registration")
	private String state_of_registration;
	@Column(name="kyc")
	private String kyc;
	@Column(name="telecom_provider")
	private String telecom_provider;
	@Column(name="full_name")
	private String full_name;

}
