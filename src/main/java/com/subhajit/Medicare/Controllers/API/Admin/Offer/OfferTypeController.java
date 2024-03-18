package com.subhajit.Medicare.Controllers.API.Admin.Offer;

import com.subhajit.Medicare.Models.DTO.OfferType;
import com.subhajit.Medicare.Services.OfferTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offerTypes")
public class OfferTypeController {

    @Autowired
    private OfferTypeService offerTypeService;

    @GetMapping
    public List<OfferType> getAllOfferTypes() {
        return offerTypeService.getAllOfferTypes();
    }

    @GetMapping("/{id}")
    public OfferType getOfferTypeById(@PathVariable String id) {
        return offerTypeService.getOfferTypeById(id);
    }

    @PostMapping
    public OfferType createOfferType(@RequestBody OfferType offerType) {
        return offerTypeService.createOfferType(offerType);
    }

    @PutMapping("/{id}")
    public OfferType updateOfferType(@PathVariable String id, @RequestBody OfferType offerType) {
        return offerTypeService.updateOfferType(id, offerType);
    }

    @DeleteMapping("/{id}")
    public void deleteOfferType(@PathVariable String id) {
        offerTypeService.deleteOfferType(id);
    }
}
