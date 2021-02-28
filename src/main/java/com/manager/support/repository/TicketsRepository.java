package com.manager.support.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.support.entity.Ticket;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long>{

}
