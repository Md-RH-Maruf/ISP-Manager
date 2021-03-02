package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.McInformation;

@Repository
public interface McInfoRepository extends JpaRepository<McInformation, Long>{

}
