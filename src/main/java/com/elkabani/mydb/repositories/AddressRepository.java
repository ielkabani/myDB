package com.elkabani.mydb.repositories;

import com.elkabani.mydb.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}