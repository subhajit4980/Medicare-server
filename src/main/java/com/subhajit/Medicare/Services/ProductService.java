package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Exceptions.ProductException;
import com.subhajit.Medicare.Mapper.ProductMapper;
import com.subhajit.Medicare.Mapper.ProductUpdateMapper;
import com.subhajit.Medicare.Models.DTO.OfferType;
import com.subhajit.Medicare.Models.DTO.Product;
import com.subhajit.Medicare.Payload.request.ProductRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.OfferTypeRepository;
import com.subhajit.Medicare.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OfferTypeRepository offerTypeRepository;
    public MessageResponse addItem(Product item) {
        if (productRepository.existsByNameAndBrand(item.getName(), item.getBrand())) {
            return (new MessageResponse("item already added! Please Update Product"));
        }
//        Product item_obj = new Product(item.getName().trim(),
//                item.getDescription(),
//                item.getPrice(),
//                item.getDiscountPercentage(),
//                item.getQuantityInStock(),
//                item.getBrand().trim(),
//                item.getManufactureDate(),
//                item.getImageUrl(),
//                item.getCategory(),
//                item.getTags(),
//                item.getOfferType(),
//                item.getShippingInfo());
//        item_obj.setExpiryDate(item.getExpiryDate());
//        item_obj.setUsageInstructions(item.getUsageInstructions());
//        item_obj.setPack_Size(item.getPack_Size());
//        item_obj.setWeight(item.getWeight());
//        item_obj.setLength(item.getLength());
//        item_obj.setWidth(item.getWidth());
//        item_obj.setHeight(item.getHeight());
//        item_obj.setColor(item.getColor());
//        item_obj.setMaterial(item.getMaterial());
//        item_obj.setPromotionalInfo(item.getPromotionalInfo());
//        item_obj.setReviews(item.getReviews());
//        item_obj.setActiveIngredients(item.getActiveIngredients());
//        item_obj.setSideEffects(item.getSideEffects());
        Product item_obj = ProductMapper.INSTANCE.toProduct(item);
        productRepository.save(item_obj);
        return new MessageResponse("item  added successfully");
    }
public MessageResponse updateItem(ProductRequest item) {
    if (productRepository.existsById(item.getItemId())) {
        Product item_obj = productRepository.findByItemId(item.getItemId())
                .orElseThrow(() -> new ProductException("Item Not Found with ID: " + item.getItemId(), "PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND));
        ProductUpdateMapper.INSTANCE.updateProductFromRequestIgnoringZeroValues(item, item_obj);
        productRepository.save(item_obj);
        return new MessageResponse("Item updated successfully");
    } else {
        throw new ProductException("Item Not Found with ID: " + item.getItemId(), "PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND);
    }
}

    public MessageResponse deleteItem(String itemId) {
        Product item_obj = productRepository.findByItemId(itemId).orElseThrow(() -> new ProductException("item Not Found " ,"PRODUCT_NOT_FOUND", HttpStatus.NOT_FOUND));
        productRepository.delete(item_obj);
        return new MessageResponse("Product was successfully deleted");
    }
}
