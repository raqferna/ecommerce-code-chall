package com.li.express.ecommerce.application.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.li.express.ecommerce.application.product.ProductFieldData;
import com.li.express.ecommerce.domain.product.ProductOrderField;

public class CreateOrderRequest implements Serializable{

	private static final long serialVersionUID = 4630124611594322733L;
	
	private String reservationId;
	private String productId;
    private List<ProductFieldData> configFields;
    
    public CreateOrderRequest(String reservationId, String productId,List<ProductFieldData> config_fields) {
    	this.reservationId = reservationId;
    	this.productId = productId;
    	this.configFields = config_fields;
    }
    

	public List<ProductOrderField> getProductOrderFields(){
		List<ProductOrderField> orderFields = new ArrayList<ProductOrderField>();
		if(!this.configFields.isEmpty()) {
			orderFields.forEach(order ->{
				orderFields.add(order);
			});
		}
		return orderFields;
	}
	
	   public String getReservationId() {
			return reservationId;
		}
	   
		public void setReservationId(String reservationId) {
			this.reservationId = reservationId;
		}
	
		public String getProductId() {
			return productId;
		}
	
		public void setProductId(String productId) {
			this.productId = productId;
		}
	
		public List<ProductFieldData> getConfigFields() {
			return configFields;
		}
	
		public void setConfigFields(List<ProductFieldData> configFields) {
			this.configFields = configFields;
		}
}
