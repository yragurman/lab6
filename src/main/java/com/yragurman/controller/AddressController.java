package com.yragurman.controller;

import com.yragurman.domain.Address;
import com.yragurman.dto.AddressDto;
import com.yragurman.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/addresses")
@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AddressDto>> getAll() {
        List<Address> addresses = addressService.getAll();
        List<AddressDto> addressDtos = new ArrayList<>();
        for (Address address : addresses) {
            AddressDto addressDto = new AddressDto(
                    address.getId(),
                    address.getCountry(),
                    address.getCity(),
                    address.getAdressName(),
                    address.getPostIndex()
            );
            addressDtos.add(addressDto);
        }
        return new ResponseEntity<>(addressDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<AddressDto> getById(@PathVariable Integer id) {
        Address address;
        try {
            address = addressService.getById(id);

            AddressDto addressDto = new AddressDto(
                    address.getId(),
                    address.getCountry(),
                    address.getCity(),
                    address.getAdressName(),
                    address.getPostIndex()
            );
            return new ResponseEntity<>(addressDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Address newAddress) {
        addressService.create(newAddress);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AddressDto> update(@PathVariable Integer id, @RequestBody Address address) {
        Address addressOld;
        try {
            addressOld = addressService.getById(id);
            if (addressOld != null) {
                addressService.update(id, address);
                AddressDto addressOldDto = new AddressDto(
                        addressOld.getId(),
                        addressOld.getCountry(),
                        addressOld.getCity(),
                        addressOld.getAdressName(),
                        addressOld.getPostIndex()
                );
                return new ResponseEntity<>(addressOldDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (addressService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
