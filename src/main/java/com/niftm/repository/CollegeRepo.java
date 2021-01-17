package com.niftm.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niftm.entity.College;

public interface CollegeRepo extends JpaRepository<College, Serializable> {

}
