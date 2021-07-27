package com.training.disasterproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.disasterproject.model.Machine;

public interface MachineRepository extends JpaRepository<Machine,String> {

}
