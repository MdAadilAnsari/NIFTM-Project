package com.niftm.entity;

/**
 * @author Aadil
 */
import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CITY")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7286804012874355327L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id",nullable = false)
	private Long id;
	
	@Column(name = "city_name",nullable = false)
	private String cityName;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "state_id", referencedColumnName = "state_id")
	private State state;

}
