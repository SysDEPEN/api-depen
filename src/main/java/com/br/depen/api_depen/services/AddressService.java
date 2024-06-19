package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import com.br.depen.api_depen.entities.Address;

public interface AddressService {

    Address save(Address address);

    List<Address> findAll();

    Optional<Address> findById(Long id);

    Address update (Address address);

    void deleteById(Long id);
}