package com.techgig.CopilotHackathon.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techgig.CopilotHackathon.dtos.ProductDto;
import com.techgig.CopilotHackathon.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping("/")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto){
       log.info("product name :{}",productDto.getProduct_name());
       ProductDto savedProductDto= this.productService.addProduct(productDto);
       return new ResponseEntity<ProductDto>(savedProductDto,HttpStatus.CREATED);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String product_id){
       ProductDto productDto= this.productService.getProduct(product_id);
       return ResponseEntity.ok(productDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos= this.productService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @PutMapping("/")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        ProductDto updatedProductDto= this.productService.updateProduct(productDto);
        return ResponseEntity.ok(updatedProductDto);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String product_id){
        this.productService.deleteProduct(product_id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/isAvailable")
    public ResponseEntity<String> isAvailable(@RequestParam(required = true) String product_id,@RequestParam(required = false,defaultValue = "1") Long quantity){
        String message= this.productService.isAvailable(product_id, quantity);
        return ResponseEntity.ok(message);
    }

}
