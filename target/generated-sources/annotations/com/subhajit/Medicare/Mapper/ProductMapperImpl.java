package com.subhajit.Medicare.Mapper;

import com.subhajit.Medicare.Models.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-08T12:12:23+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(Product item) {
        if ( item == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( trimString( item.getName() ) );
        product.setBrand( trimString( item.getBrand() ) );
        product.setItemId( item.getItemId() );
        List<String> list = item.getDescription();
        if ( list != null ) {
            product.setDescription( new ArrayList<String>( list ) );
        }
        product.setPrice( item.getPrice() );
        product.setDiscountPercentage( item.getDiscountPercentage() );
        product.setQuantityInStock( item.getQuantityInStock() );
        product.setManufactureDate( item.getManufactureDate() );
        List<String> list1 = item.getImageUrl();
        if ( list1 != null ) {
            product.setImageUrl( new ArrayList<String>( list1 ) );
        }
        product.setCategory( item.getCategory() );
        List<String> list2 = item.getTags();
        if ( list2 != null ) {
            product.setTags( new ArrayList<String>( list2 ) );
        }
        product.setOfferType( item.getOfferType() );
        product.setShippingInfo( item.getShippingInfo() );
        product.setExpiryDate( item.getExpiryDate() );
        product.setUsageInstructions( item.getUsageInstructions() );
        product.setPack_Size( item.getPack_Size() );
        List<Double> list3 = item.getWeight();
        if ( list3 != null ) {
            product.setWeight( new ArrayList<Double>( list3 ) );
        }
        product.setWeightUnit( item.getWeightUnit() );
        product.setLength( item.getLength() );
        product.setLengthUnit( item.getLengthUnit() );
        product.setWidth( item.getWidth() );
        product.setHeight( item.getHeight() );
        List<String> list4 = item.getColor();
        if ( list4 != null ) {
            product.setColor( new ArrayList<String>( list4 ) );
        }
        List<String> list5 = item.getMaterial();
        if ( list5 != null ) {
            product.setMaterial( new ArrayList<String>( list5 ) );
        }
        product.setPromotionalInfo( item.getPromotionalInfo() );
        product.setActiveIngredients( item.getActiveIngredients() );
        List<String> list6 = item.getSideEffects();
        if ( list6 != null ) {
            product.setSideEffects( new ArrayList<String>( list6 ) );
        }
        List<String> list7 = item.getReviews();
        if ( list7 != null ) {
            product.setReviews( new ArrayList<String>( list7 ) );
        }
        product.setBuyer( item.getBuyer() );
        product.setRating( item.getRating() );

        return product;
    }
}
