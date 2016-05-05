/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.Item;
import com.mcac0006.siftscience.types.PaymentMethod;

/**
 * Use $create_order to record when a user submits an order for products or services they intend to purchase. 
 * This API event ideally contains the products/services ordered, the payment instrument proposed, and user 
 * identification data. See: <a href="https://siftscience.com/docs/tutorials/integration">Integration Tutorial</a>.
 * 
 * @author matthew.cachia
 *
 */
public class CreateOrder extends Event {
		
	/**
	 * The user's account ID according to your systems. Use the same ID that you would use to look up users 
	 * on your website's databases. This field is required on all events performed by the user while logged in. 
	 * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are 
	 * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$user_id")
	private String userId;
	
	/**
	 * The user's current session ID, used to tie a user's action before and after log in or account creation.
	 */
	@JsonProperty("$session_id")
	private String sessionId;
	
	/**
	 * The ID for tracking this order in your system.
	 */
	@JsonProperty("$order_id")
	private String orderId;
	
	@JsonProperty("$user_email")
	private String userEmail;
	
	/**
	 * Total transaction amount in micros in the base unit of the <code>$currency_code</code>. 1 cent = 10,000 
	 * micros. $1.23 USD = 123 cents = 1,230,000 micros.
	 */
	@JsonProperty("$amount")
	private Long amount;
	
	/**
	 * <a href="http://en.wikipedia.org/wiki/ISO_4217">ISO-4217</a> currency code for the amount. If your site 
	 * uses alternative currencies, specifiy them here.
	 */
	@JsonProperty("$currency_code")
	private String currencyCode;
	
	/**
	 * The billing address as entered by the user. Represented as a nested {@link Address} object.
	 */
	@JsonProperty("$billing_address")
	private Address billingAddress;
	
	/**
	 * The payment information associated with this order. Represented as an array of nested {@link PaymentMethod} 
	 * objects containing payment type, payment gateway, credit card bin, etc.
	 */
	@JsonProperty("$payment_methods")
	private PaymentMethod[] paymentMethods;
	
	/**
	 * The shipping address as entered by the user. Represented as a nested {@link Address} object.
	 */
	@JsonProperty("$shipping_address")
	private Address shippingAddress;
	
	/**
	 * Whether the user requested priority/expedited shipping on their order.
	 */
	@JsonProperty("$expedited_shipping")
	private Boolean expeditedShipping;
	
	
	/**
	 * The list of {@link Item}s ordered.
	 */
	@JsonProperty("$items")
	private Item[] items;
	
	/**
	 * For marketplace businesses, this is the seller's user ID, typically a database primary key. Note: User IDs are case sensitive. 
	 * You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$seller_user_id")
	private String sellerUserId;
	
	
	public CreateOrder() {
		super("$create_order");
	}


	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public String getOrderId() {
		return orderId;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public Long getAmount() {
		return amount;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public Address getBillingAddress() {
		return billingAddress;
	}


	public PaymentMethod[] getPaymentMethods() {
		return paymentMethods;
	}


	public Address getShippingAddress() {
		return shippingAddress;
	}


	public Boolean getExpeditedShipping() {
		return expeditedShipping;
	}


	public CreateOrder setUserId(String userId) {
		this.userId = userId;
		return this;
	}


	public CreateOrder setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}


	public CreateOrder setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}


	public CreateOrder setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}


	public CreateOrder setAmount(Long amount) {
		this.amount = amount;
		return this;
	}


	public CreateOrder setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}


	public CreateOrder setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}


	public CreateOrder setPaymentMethods(PaymentMethod[] paymentMethods) {
		this.paymentMethods = paymentMethods;
		return this;
	}


	public CreateOrder setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
		return this;
	}


	public CreateOrder setExpeditedShipping(Boolean expeditedShipping) {
		this.expeditedShipping = expeditedShipping;
		return this;
	}


	public CreateOrder setItems(Item[] items) {
		this.items = items;
		return this;
	}


	public CreateOrder setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
		return this;
	}


	public Item[] getItems() {
		return items;
	}


	public String getSellerUserId() {
		return sellerUserId;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result
                + ((billingAddress == null) ? 0 : billingAddress.hashCode());
        result = prime * result
                + ((currencyCode == null) ? 0 : currencyCode.hashCode());
        result = prime
                * result
                + ((expeditedShipping == null) ? 0 : expeditedShipping
                        .hashCode());
        result = prime * result + Arrays.hashCode(items);
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + Arrays.hashCode(paymentMethods);
        result = prime * result
                + ((sellerUserId == null) ? 0 : sellerUserId.hashCode());
        result = prime * result
                + ((sessionId == null) ? 0 : sessionId.hashCode());
        result = prime * result
                + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
        result = prime * result
                + ((userEmail == null) ? 0 : userEmail.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (!super.equals(obj)) {
            return false;
        }

        if (obj == null || !(obj instanceof CreateOrder)) {
            return false;
        }
        
        final CreateOrder co = (CreateOrder)obj;
        
        if (this.expeditedShipping == null) {
            if (co.getExpeditedShipping() != null) {
                return false;
            }
        } else if (!this.expeditedShipping.equals(co.getExpeditedShipping())) {
            return false;
        }
        
        if (this.amount == null) {
            if (co.getAmount() != null) {
                return false;
            }
        } else if (!this.amount.equals(co.getAmount())) {
            return false;
        }
        
        if (this.billingAddress == null) {
            if (co.getBillingAddress() != null) {
                return false;
            }
        } else if (!this.billingAddress.equals(co.getBillingAddress())) {
            return false;
        }
        
        if (this.currencyCode == null) {
            if (co.getCurrencyCode() != null) {
                return false;
            }
        } else if (!this.currencyCode.equals(co.getCurrencyCode())) {
            return false;
        }
        
        if (this.items == null) {
            if (co.getItems() != null) {
                return false;
            }
        } else if (!Arrays.equals(this.items, co.getItems())) {
            return false;
        }
        
        if (this.orderId == null) {
            if (co.getOrderId() != null) {
                return false;
            }
        } else if (!this.orderId.equals(co.getOrderId())) {
            return false;
        }
        
        if (this.paymentMethods == null) {
            if (co.getPaymentMethods() != null) {
                return false;
            }
        } else if (!Arrays.equals(this.paymentMethods, co.getPaymentMethods())) {
            return false;
        }
        
        if (this.sellerUserId == null) {
            if (co.getSellerUserId() != null) {
                return false;
            }
        } else if (!this.sellerUserId.equals(co.getSellerUserId())) {
            return false;
        }
        
        if (this.sessionId == null) {
            if (co.getSessionId() != null) {
                return false;
            }
        } else if (!this.sessionId.equals(co.getSessionId())) {
            return false;
        }
        
        if (this.shippingAddress == null) {
            if (co.getShippingAddress() != null) {
                return false;
            }
        } else if (!this.shippingAddress.equals(co.getShippingAddress())) {
            return false;
        }
        
        if (this.userEmail == null) {
            if (co.getUserEmail() != null) {
                return false;
            }
        } else if (!this.userEmail.equals(co.getUserEmail())) {
            return false;
        }
        
        if (this.userId == null) {
            if (co.getUserId() != null) {
                return false;
            }
        } else if (!this.userId.equals(co.getUserId())) {
            return false;
        }
        
        return true;
    }
	
}
