package com.li.express.ecommerce.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Product {
	
	private ProductId productId;
    private String productName;
    private ProductDescription productDescription;
    private Date productDateCreated;
    private double productPrice;
    private List<ProductOrderField> productOrderFields;
    private ProductStatus productStatus;
    
    

    public Product(ProductId id, String productName, ProductDescription productDescription, double productPrice,
			List<ProductOrderField> productOrderFields) {
	    	this.productDescription = productDescription;
	    	this.productName = productName;
	    	this.productPrice=productPrice;
	    	this.productId = id;
	    	this.productDateCreated= new Date();
	    	this.productOrderFields = productOrderFields;
	    	this.productStatus = ProductStatus.ACTIVE;
	}
    
 
    
    public boolean isActive() {
      return ProductStatus.ACTIVE.equals(this.productStatus);
    }
    
	public void inactiveProduct() {
        productStatus = ProductStatus.INACTIVE;
    }
	public void activeProduct() {
        productStatus = ProductStatus.ACTIVE;
    }
	
	public ProductId getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public ProductDescription getProductDescription() {
		return productDescription;
	}

	public Date getProductDateCreated() {
		return productDateCreated;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public List<ProductOrderField> getProductOrderFields() {
		return productOrderFields;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}


	
 public static final class ProductBuilder {
	    private String productName;
	    private ProductDescription productDescription;
	    private double productPrice;
	    private List<ProductOrderField> productOrderFields;
	    private ProductId productId;
	    
	    public ProductBuilder productId(ProductId productId) {
	    	this.productId = productId;
	    	return this;
	    }
	   
	    public ProductBuilder productName(String productName) {
	    	this.productName = productName;
	    	return this;
	    }
	    public ProductBuilder productDescription(ProductDescription productDescription) {
	    	this.productDescription = productDescription;
	    	return this;
	    }
	    public ProductBuilder productPrice(double productPrice) {
	    	this.productPrice = productPrice;
	    	return this;
	    }
	
	    public Product build() {
	    	return new Product(productId, productName, productDescription,productPrice,productOrderFields );
	    }
  }
 

}
