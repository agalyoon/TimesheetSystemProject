package com.training.disasterproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.disasterproject.model.Site;

public interface SiteRepository extends JpaRepository<Site, String>{

}
