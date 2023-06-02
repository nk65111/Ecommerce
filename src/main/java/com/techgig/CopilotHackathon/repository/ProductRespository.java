package com.techgig.CopilotHackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techgig.CopilotHackathon.model.Product;

public interface ProductRespository extends JpaRepository<Product, String>{
    
}
