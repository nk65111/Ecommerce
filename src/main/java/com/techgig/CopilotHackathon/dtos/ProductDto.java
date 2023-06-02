package com.techgig.CopilotHackathon.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.techgig.CopilotHackathon.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    
    private String product_id;
    
    @NotNull(message = "Product name cannot be null")
    @Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
    private String product_name;
    
    @NotNull(message = "Product description cannot be null")
    @Size(min = 10, max = 500, message = "Product description must be between 10 and 500 characters")
    private String product_description;

    @NotNull(message = "Product image cannot be null")
    private String product_image;

    @NotNull(message = "Product price cannot be null")
    private String product_price;

    @NotNull(message = "Product category cannot be null")
    @Size(min = 2, max = 500, message = "Product category must be between 2 and 500 characters")
    private String product_category;

    @NotNull(message = "Product brand cannot be null")
    @Size(min = 2, max = 500, message = "Product brand must be between 2 and 500 characters")
    private String product_brand;
    
    @NotNull(message = "Product quantity cannot be null")
    @Min(value = 1, message = "Product quantity must be greater than or equal to 1")
    private Long product_quantity;

    public static Product changeProductDtoToProduct(ProductDto productDto){
        return Product.builder()
                      .product_id(productDto.getProduct_id())
                      .product_name(productDto.getProduct_name())
                      .product_description(productDto.getProduct_description())
                      .product_image(productDto.getProduct_image())
                      .product_price(productDto.getProduct_price())
                      .product_category(productDto.getProduct_category())
                      .product_brand(productDto.getProduct_brand())
                      .product_quantity(productDto.getProduct_quantity())
                      .build();
    }

    public static ProductDto changeProducToProductDto(Product product){
        return ProductDto.builder()
                         .product_id(product.getProduct_id())
                         .product_name(product.getProduct_name())
                         .product_description(product.getProduct_description())
                         .product_image(product.getProduct_image())
                         .product_price(product.getProduct_price())
                         .product_category(product.getProduct_category())
                         .product_brand(product.getProduct_brand())
                         .product_quantity(product.getProduct_quantity())
                         .build();
    }
}
