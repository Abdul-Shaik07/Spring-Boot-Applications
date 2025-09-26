package com.wipro.busbookingproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.busbookingproject.entity.Bus;
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
	
	Bus findByTicketId(long ticketId);
	
	List<Bus> findByTicketPriceGreaterThan(double ticketPrice);
	
//	@Modifying
//	@Query("update Bus b set b.departureDate = :departureDate where b.busId = :busId")
//	Bus updateBus(@Param("departureDate") Date departureDate, @Param("busId") long busId);
	
	
	
	

}
