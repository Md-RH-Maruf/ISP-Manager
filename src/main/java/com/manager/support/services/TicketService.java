package com.manager.support.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.support.entity.Ticket;
import com.manager.support.repository.TicketsRepository;

@Service
public class TicketService {

	@Autowired
	TicketsRepository ticketRepository;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public Ticket getTicket(long id) {
		return ticketRepository.findById(id).orElse(null);
	}
}
