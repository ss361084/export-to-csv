package com.springboot.poc.service.impl;

import com.springboot.poc.entity.Address;
import com.springboot.poc.repository.AddressRepository;
import com.springboot.poc.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        logger.info("Request to save Address");
        return addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Request to delete Address by Id : {0}", id);
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getAllAddress() {
        logger.info("Request to Get All Addresses");
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        logger.info("Request to Get Address by Id : {0}", id);
        return addressRepository.findById(id);
    }

    @Override
    public Optional<Address> getAddressByCity(String city) {
        logger.info("Request to Get Address by City : {0}", city);
        return addressRepository.findByCity(city);
    }

    @Override
    public Optional<Address> getAddressByPincode(String pincode) {
        logger.info("Request to Get Address by Pincode : {0}", pincode);
        return addressRepository.findByPincode(pincode);
    }

    @Override
    public Optional<Address> getAddressByCityAndPincode(String city, String pincode) {
        logger.info("Request to Get Address by City : {0} and Pincode : {1}", city, pincode);
        return addressRepository.findByCityAndPincode(city, pincode);
    }
}
