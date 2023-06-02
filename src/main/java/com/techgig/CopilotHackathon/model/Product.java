package com.techgig.CopilotHackathon.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    
    //suggest product instance 
    @Id
    private String product_id;
    private String product_name;
    private String product_description;
    private String product_image;
    private String product_price;
    private String product_category;
    private String product_brand;
    private Long product_quantity;

}
