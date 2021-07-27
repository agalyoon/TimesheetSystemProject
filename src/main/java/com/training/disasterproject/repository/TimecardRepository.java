package com.training.disasterproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.disasterproject.model.Timecard;
import com.training.disasterproject.model.User;

@Repository
public interface TimecardRepository extends JpaRepository<Timecard, Long> {
	List<Timecard> findAllByName(String name);
}
