package com.java.product.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.product.Entity.Player;
@Repository
public interface PlayerRepository extends JpaRepository<Player ,Integer> {
	
	List<Player> findByType(String type);
	List<Player> findAllByOrderByNameAsc();

}
