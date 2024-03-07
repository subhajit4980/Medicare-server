package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Exceptions.ProductException;
import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Payload.request.ProductRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public MessageResponse addItem(Product item) {
        if (productRepository.existsByNameAndBrand(item.getName(), item.getBrand())) {
            return (new MessageResponse("item already added! Please Update Product"));
        }
        Product item_obj = new Product( item.getName().trim(),
                item.getCategories(),
                item.getDescription(),
                item.getPrice(),
                item.getDiscountPercentage(),
                item.getQuantityInStock(),
                item.getBrand().trim(),
                item.getManufactureDate(),
                item.getExpiryDate(),
                item.getActiveIngredients(),
                item.getUsageInstructions(),
                item.getImageUrl() );
        item_obj.setQuantityInStock(item.getQuantityInStock());
        item_obj.setPack_Size(item.getPack_Size());
        item_obj.setSideEffects(item.getSideEffects());
        item_obj.setBuyer(0);
        item_obj.setRating(0.0);
        item_obj.setAvailabilityStatus(true);
        item_obj.setOfferType(item.getOfferType());
        productRepository.save(item_obj);
        return new MessageResponse("item  added successfully");
    }
    public MessageResponse updateItem(@Valid @RequestBody ProductRequest item) {
        if (productRepository.existsById(item.getItemId())) {
            Product item_obj = productRepository.findByItemId(item.getItemId()).orElseThrow(() -> new UsernameNotFoundException("item Not Found with name: " + item.getName()));
            if (item.getQuantityInStock() >= 0)
                item_obj.setQuantityInStock(item.getQuantityInStock());
            if (item.getPrice() > 0)
                item_obj.setPrice(item.getPrice());
            if (item.getDiscountPercentage() >= 0)
                item_obj.setDiscountPercentage(item.getDiscountPercentage());
            if (item.getExpiryDate() != null && item.getQuantityInStock() >= 0)
                item_obj.setExpiryDate(item.getExpiryDate());
            if (item.getOfferType() != null)
                item_obj.setOfferType(item.getOfferType());
            if (item.getCategory()!=null)
                item_obj.getCategories().addAll(item.getCategory());
            productRepository.save(item_obj);
            return new MessageResponse("item updated successfully");
        } else throw new ProductException("item Not Found with name: " + item.getName(),"PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }
    public MessageResponse deleteItem(@Valid @RequestBody ProductRequest item) {
        Product item_obj = productRepository.findByItemId(item.getItemId()).orElseThrow(() -> new ProductException("item Not Found with name: " + item.getName(),"PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND));
        productRepository.delete(item_obj);
        return new MessageResponse("Product was successfully deleted");
    }
}
