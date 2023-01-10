package com.springboot.poc.service;

import com.springboot.poc.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address save(Address address);
    void deleteById(Long id);
    List<Address> getAllAddress();
    Optional<Address> getAddressById(Long id);
    Optional<Address> getAddressByCity(String city);
    Optional<Address> getAddressByPincode(String pincode);
    Optional<Address> getAddressByCityAndPincode(String city, String pincode);
}
