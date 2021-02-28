package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.ConnectionPoint;

@Repository
public interface ConnectionPointRepository extends JpaRepository<ConnectionPoint, Long>{
	public ConnectionPoint findByConnectionPointName(String connectionPointName);
	public ConnectionPoint findByConnectionPointNameAndIdNot(String connectionPointName,long id);
}
