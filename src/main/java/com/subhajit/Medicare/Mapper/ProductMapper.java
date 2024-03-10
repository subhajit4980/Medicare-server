package com.subhajit.Medicare.Mapper;

import com.subhajit.Medicare.Models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "name", qualifiedByName = "trimString"),
            @Mapping(target = "brand", source = "brand", qualifiedByName = "trimString")
    })
    Product toProduct(Product item);
    @Named("trimString")
    default String trimString(String value) {
        return value != null ? value.trim() : null;
    }
}
