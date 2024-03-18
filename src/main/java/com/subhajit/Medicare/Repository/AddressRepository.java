package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends MongoRepository<Address, String> {
    List<Address> findByUserId(String username);
    boolean existsByAddressId(String addressId);
}
