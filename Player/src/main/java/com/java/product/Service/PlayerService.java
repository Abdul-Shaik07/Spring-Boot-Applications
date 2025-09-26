package com.java.product.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.product.Entity.Player;
import com.java.product.Repository.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	PlayerRepository playerRepository;
	
	// post
	
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}
	
	// update
	
	public Player updatePlayer(Player player) {
		return playerRepository.save(player);
	}
	
	// deleteById
	
	public void deleteById(int id) {
		if(playerRepository.existsById(id))
			playerRepository.deleteById(id);
	}
	
	// Get Player
	
	public List<Player> getPlayer() {
		return playerRepository.findAll();
	}
	
	// Get Players in Bat
	
	public List<Player> findByType(String type) {
		return playerRepository.findByType(type);
			
	}
	
	// find by asc
	
	public List<Player> findAllByOrderByNameAsc(int page, int size) {
		return playerRepository.findAllByOrderByNameAsc();
	}
	
	

}
