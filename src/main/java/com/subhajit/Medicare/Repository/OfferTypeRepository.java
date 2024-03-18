package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.DTO.OfferType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OfferTypeRepository extends MongoRepository<OfferType, String> {
    Optional<OfferType> findByName(String name);
    Optional<OfferType> findByOfferCode(String offerCode);
}
