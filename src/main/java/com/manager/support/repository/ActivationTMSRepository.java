package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.ActivationTMS;
@Repository
public interface ActivationTMSRepository extends JpaRepository<ActivationTMS, Long>{

}
