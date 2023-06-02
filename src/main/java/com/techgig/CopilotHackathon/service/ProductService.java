package com.techgig.CopilotHackathon.service;

import java.util.List;

import com.techgig.CopilotHackathon.dtos.ProductDto;

public interface ProductService {
    public ProductDto getProduct(String product_id);
    public List<ProductDto> getAllProducts();
    public ProductDto addProduct(ProductDto productDto);
    public ProductDto updateProduct(ProductDto productDto);
    public void deleteProduct(String product_id);
    public String isAvailable(String product_id, Long quantity);
}
