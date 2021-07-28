package com.training.disasterproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.disasterproject.model.Machine;
import com.training.disasterproject.model.Site;
import com.training.disasterproject.model.User;

public interface MachineRepository extends JpaRepository<Machine,String> {
	@Query("from Machine mc where mc.site =:site and mc.user=:user")

	List<Machine> findAllBySiteAndMachine(Site site, User user);

}
