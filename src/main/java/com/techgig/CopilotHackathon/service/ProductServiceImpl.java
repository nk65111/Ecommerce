package com.techgig.CopilotHackathon.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techgig.CopilotHackathon.dtos.ProductDto;
import com.techgig.CopilotHackathon.exception.ProductException;
import com.techgig.CopilotHackathon.model.Product;
import com.techgig.CopilotHackathon.repository.ProductRespository;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRespository productRepository;

    @Override
    public ProductDto getProduct(String product_id) {
       Product product= this.productRepository.findById(product_id).orElseThrow(()->new ProductException("Product not found with id: "+product_id,"failed"));
       return ProductDto.changeProducToProductDto(product);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
       Product product= ProductDto.changeProductDtoToProduct(productDto);
       product.setProduct_id(UUID.randomUUID().toString());
       Product savedProduct= this.productRepository.save(product);
       return ProductDto.changeProducToProductDto(savedProduct);    
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product=  this.productRepository.findById(productDto.getProduct_id()).orElseThrow(()->new  ProductException("Product not found with id: "+productDto.getProduct_id(),"failed"));
        if(productDto.getProduct_name()!=null&&productDto.getProduct_name().length()>0){
            product.setProduct_name(productDto.getProduct_name());
        }
        if(productDto.getProduct_description()!=null&&productDto.getProduct_description().length()>0){
            product.setProduct_description(productDto.getProduct_description());
        }
        if(productDto.getProduct_image()!=null&&productDto.getProduct_image().length()>0){
            product.setProduct_image(productDto.getProduct_image());
        }
        if(productDto.getProduct_price()!=null&&productDto.getProduct_price().length()>0){
            product.setProduct_price(productDto.getProduct_price());
        }
        if(productDto.getProduct_quantity()!=null&&productDto.getProduct_quantity()>0){
            product.setProduct_quantity(productDto.getProduct_quantity());
        }
        if(productDto.getProduct_category()!=null&&productDto.getProduct_category().length()>0){
            product.setProduct_category(productDto.getProduct_category());
        }
        if(productDto.getProduct_brand()!=null&&productDto.getProduct_brand().length()>0){
            product.setProduct_brand(productDto.getProduct_brand());
        }
        Product savedProduct= this.productRepository.save(product);
        return ProductDto.changeProducToProductDto(savedProduct);
    }

    @Override
    public void deleteProduct(String product_id) {
        Product product=  this.productRepository.findById(product_id).orElseThrow(()->new  ProductException("Product not found with id: "+product_id,"failed"));
        this.productRepository.delete(product);
    }

    @Override
    public String isAvailable(String product_id, Long quantity) {
        Product product=  this.productRepository.findById(product_id).orElseThrow(()->new ProductException("Product not found with id: "+product_id,"failed"));
        if(product.getProduct_quantity()>=quantity){
            return "Product is available";
        }
        else{
            throw new ProductException("Product have only "+product.getProduct_quantity()+" quantity","failed");
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products= this.productRepository.findAll();
        return products.stream().map(ProductDto::changeProducToProductDto).toList();
    }

    
}
