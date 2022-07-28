package com.hieu276.fleetms.helpdesk.repositories;

import com.hieu276.fleetms.helpdesk.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
