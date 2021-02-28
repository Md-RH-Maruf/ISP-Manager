package com.manager.support.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.ConnectionPoint;
import com.manager.support.repository.ConnectionPointRepository;

@Service
public class ConnectionPointService {
	@Autowired
	ConnectionPointRepository connPointRepository;
	
	public ConnectionPoint saveConnectionPoint(ConnectionPoint connectionPoint) {
		return connPointRepository.save(connectionPoint);
	}
	
	public ConnectionPoint findConnectionPoint(long id) {
		return connPointRepository.findById(id).orElse(null);
	}
	
	public List<ConnectionPoint> getConnectionPointList(){
		return connPointRepository.findAll();
	}
	
	public ConnectionPoint getConnectionPoint(String connectionPointName) {
		return connPointRepository.findByConnectionPointName(connectionPointName);
	}
	
	public boolean isConnectionPointExist(String connectionPointName,long id) {
		if(connPointRepository.findByConnectionPointNameAndIdNot(connectionPointName, id) != null) {
			return true;
		}else {
			return false;
		}
	}
}
