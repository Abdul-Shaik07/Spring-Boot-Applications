package com.java.mappings.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.mappings.Entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
