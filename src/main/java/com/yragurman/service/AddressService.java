package com.yragurman.service;

import com.yragurman.domain.Address;
import com.yragurman.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements  AbstractService<Address, Integer>{

    private final AddressRepository addressRepository;

    public AddressService (AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(Integer id) {
        return addressRepository.getOne(id);
    }

    @Override
    public Address create(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    @Override
    public Address update(Integer id, Address address) {
        if (addressRepository.findById(id).isPresent()) {
            return addressRepository.save(address);
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (addressRepository.findById(id).isPresent()) {
            addressRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
