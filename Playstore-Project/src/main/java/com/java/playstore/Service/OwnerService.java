package com.java.playstore.service;

import com.java.playstore.entity.Owner;
import com.java.playstore.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Long id, Owner ownerDetails) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setUsername(ownerDetails.getUsername());
        owner.setEmail(ownerDetails.getEmail());
        owner.setPassword(ownerDetails.getPassword());
        owner.setCreatedDate(ownerDetails.getCreatedDate());
        owner.setUpdateDate(ownerDetails.getUpdateDate());
        return ownerRepository.save(owner);
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
}
