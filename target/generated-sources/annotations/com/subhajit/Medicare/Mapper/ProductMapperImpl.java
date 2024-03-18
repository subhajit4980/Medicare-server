package com.subhajit.Medicare.Mapper;

import com.subhajit.Medicare.Models.DTO.Product;
import com.subhajit.Medicare.Models.Review;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-16T02:34:09+0530",
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
        product.setSubCategory( item.getSubCategory() );
        List<String> list2 = item.getTags();
        if ( list2 != null ) {
            product.setTags( new ArrayList<String>( list2 ) );
        }
        product.setOfferCode( item.getOfferCode() );
        product.setShippingInfo( item.getShippingInfo() );
        product.setExpiryDate( item.getExpiryDate() );
        product.setUsageInstructions( item.getUsageInstructions() );
        product.setPack_Size( item.getPack_Size() );
        List<Double> list3 = item.getWeight();
        if ( list3 != null ) {
            product.setWeight( new ArrayList<Double>( list3 ) );
        }
        product.setWeightUnit( item.getWeightUnit() );
        List<Double> list4 = item.getLength();
        if ( list4 != null ) {
            product.setLength( new ArrayList<Double>( list4 ) );
        }
        product.setLengthUnit( item.getLengthUnit() );
        List<Double> list5 = item.getWidth();
        if ( list5 != null ) {
            product.setWidth( new ArrayList<Double>( list5 ) );
        }
        List<Double> list6 = item.getHeight();
        if ( list6 != null ) {
            product.setHeight( new ArrayList<Double>( list6 ) );
        }
        List<String> list7 = item.getColor();
        if ( list7 != null ) {
            product.setColor( new ArrayList<String>( list7 ) );
        }
        List<String> list8 = item.getMaterial();
        if ( list8 != null ) {
            product.setMaterial( new ArrayList<String>( list8 ) );
        }
        List<String> list9 = item.getPromotionalInfo();
        if ( list9 != null ) {
            product.setPromotionalInfo( new ArrayList<String>( list9 ) );
        }
        product.setActiveIngredients( item.getActiveIngredients() );
        List<String> list10 = item.getSideEffects();
        if ( list10 != null ) {
            product.setSideEffects( new ArrayList<String>( list10 ) );
        }
        List<Review> list11 = item.getReviews();
        if ( list11 != null ) {
            product.setReviews( new ArrayList<Review>( list11 ) );
        }
        product.setBuyer( item.getBuyer() );
        product.setRating( item.getRating() );

        return product;
    }
}
