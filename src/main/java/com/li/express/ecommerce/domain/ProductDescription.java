package com.li.express.ecommerce.domain;


public class ProductDescription {
    private final  String description;

    public ProductDescription(String description) {
        this.description = description != null ? description : "";
    }

	public String value() {
        return description;
    }

}
