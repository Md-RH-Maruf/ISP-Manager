package com.manager.support.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.WorkTeam;
import com.manager.support.repository.TicketsRepository;

@Service
public class TicketService {

	@Autowired
	TicketsRepository ticketRepository;
	
	public WorkTeam saveTicket(WorkTeam ticket) {
		return ticketRepository.save(ticket);
	}
	
	public WorkTeam getTicket(long id) {
		return ticketRepository.findById(id).orElse(null);
	}
}
