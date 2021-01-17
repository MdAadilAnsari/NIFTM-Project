package com.niftm.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.niftm.entity.State;

public interface StateRepo extends JpaRepository<State, Serializable> {

}
