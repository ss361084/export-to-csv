package com.springboot.poc.repository;

import com.springboot.poc.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByCity(String city);
    Optional<Address> findByPincode(String pincode);
    Optional<Address> findByCityAndPincode(String city, String pincode);
}
