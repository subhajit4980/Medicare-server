package com.subhajit.Medicare.Mapper;
import com.subhajit.Medicare.Models.Product;
import com.subhajit.Medicare.Payload.request.ProductRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductUpdateMapper {
    ProductUpdateMapper INSTANCE = Mappers.getMapper(ProductUpdateMapper.class);
    @Mapping(target = "itemId", ignore = true) // Ignore mapping for id (assuming it's managed by the repository)
    default void updateProductFromRequestIgnoringZeroValues(ProductRequest request, @MappingTarget Product product) {
        if (request.getPrice() != 0) {
            product.setPrice(request.getPrice());
        }
        if (request.getDiscountPercentage() != 0) {
            product.setDiscountPercentage(request.getDiscountPercentage());
        }
        if (request.getQuantityInStock() != 0) {
            product.setQuantityInStock(request.getQuantityInStock());
        }
        if (request.getLength() != 0) {
            product.setLength(request.getLength());
        }
        if (request.getWidth() != 0) {
            product.setWidth(request.getWidth());
        }
        if (request.getHeight() != 0) {
            product.setHeight(request.getHeight());
        }
    }
}
