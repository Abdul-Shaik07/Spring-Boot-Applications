package com.java.product.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.java.product.Entity.Player;
import com.java.product.Repository.PlayerRepository;
import com.java.product.Service.PlayerService;
@RestController
public class PlayerController {
	@Autowired
	PlayerService playerService;
	@Autowired
	PlayerRepository playerRepository;
	@PostMapping("/Player")
	public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
		if((playerRepository.existsById(player.getId()))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "already exists");
		}
		
		if (!(player.getMobile()).equalsIgnoreCase("7896746352") || !(player.getEmail()).equalsIgnoreCase("xyz@gmail.com")) {
            throw new ResponseStatusException(HttpStatus.MULTIPLE_CHOICES, "Invalid mobile format");
        }
        
        if ((player.getHeight() < 4.5)) {
            throw new ResponseStatusException(HttpStatus.MOVED_PERMANENTLY, "Invalid status. Must be 'allowed' or 'blocked'");
        }
        else {
        	System.out.println("height");
        }
        
        if ((player.getWeight() < 50.0)) {
            throw new ResponseStatusException(HttpStatus.MOVED_PERMANENTLY, "Invalid status. Must be 'allowed' or 'blocked'");
        }
        else {
        	System.out.println("weight");
        }

		return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
	}
	
	@PutMapping("/Player")
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
		
		if(playerRepository.existsById(player.getId())) {
			playerService.updatePlayer(player);
		}
		
		if(!(playerRepository.existsById(player.getId()))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		if (!(player.getMobile()).equalsIgnoreCase("7896746352") || !(player.getEmail()).equalsIgnoreCase("xyz@gmail.com")) {
            throw new ResponseStatusException(HttpStatus.MULTIPLE_CHOICES, "Invalid mobile format");
        }

        if (player.getWeight() < 50) {
            throw new ResponseStatusException(HttpStatus.MOVED_PERMANENTLY, "Invalid status. Must be 'allowed' or 'blocked'");
        }
        
        if (player.getHeight() < 4.5) {
            throw new ResponseStatusException(HttpStatus.MOVED_PERMANENTLY, "Invalid status. Must be 'allowed' or 'blocked'");
        }
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}
	
	@DeleteMapping("/Player/{id}")
	public ResponseEntity<Player> deleteById(@PathVariable int id, @RequestBody Player player) {
		if(!(playerRepository.existsById(id)))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		if(playerRepository.existsById(id)) {
			playerService.deleteById(id);
		}
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}
	
	
	@GetMapping("/Player")
	public ResponseEntity<List<Player>> getPlayer() {
		return new ResponseEntity<List<Player>>(playerService.getPlayer(), HttpStatus.OK);
	}
	
	@GetMapping("/Player/{type}")
	public ResponseEntity<List<Player>> findByType(@PathVariable String type) {
		return new ResponseEntity<List<Player>>(playerService.findByType(type), HttpStatus.OK);
	}
	@GetMapping("/Players/0 & 1")
	public ResponseEntity<List<Player>> findAllByOrderByNameAsc(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return new ResponseEntity<List<Player>>(playerService.findAllByOrderByNameAsc(page, size), HttpStatus.OK);
		
	}
}
