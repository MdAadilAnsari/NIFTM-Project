package com.niftm.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niftm.entity.City;

public interface CityRepo extends JpaRepository<City, Serializable> {

}
