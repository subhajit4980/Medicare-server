package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Models.DTO.OfferType;
import com.subhajit.Medicare.Repository.OfferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferTypeService {

    @Autowired
    private OfferTypeRepository offerTypeRepository;

    public List<OfferType> getAllOfferTypes() {
        return offerTypeRepository.findAll();
    }

    public OfferType getOfferTypeById(String id) {
        return offerTypeRepository.findById(id).orElse(null);
    }

    public OfferType createOfferType(OfferType offerType) {
        return offerTypeRepository.save(offerType);
    }

    public OfferType updateOfferType(String id, OfferType offerType) {
        if (offerTypeRepository.existsById(id)) {
            offerType.setId(id);
            return offerTypeRepository.save(offerType);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteOfferType(String id) {
        offerTypeRepository.deleteById(id);
    }
}
