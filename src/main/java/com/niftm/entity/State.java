package com.niftm.entity;
/**
 * @author Aadil
 */
import java.io.Serializable;
import java.util.List;

import javax.management.remote.TargetedNotification;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATE")
public class State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 717968914448763628L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id", nullable = false)
	private Long id;

	@Column(name = "state_name",nullable = false)
	private String stateName;
	
	/*
	 * @OneToMany(mappedBy = "state",fetch = FetchType.LAZY,cascade =
	 * CascadeType.ALL,orphanRemoval = true) private List<City> city;
	 */
}
