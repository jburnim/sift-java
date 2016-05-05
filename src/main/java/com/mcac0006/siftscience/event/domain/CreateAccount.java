/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

import com.mcac0006.siftscience.types.Address;
import com.mcac0006.siftscience.types.PaymentMethod;
import com.mcac0006.siftscience.types.SocialSignOnType;

/**
 * Use {@link CreateAccount} to capture account creation and user details. To capture updates to an account after 
 * it is initially created, please use {@link UpdateAccount}.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class CreateAccount extends Event {
		
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
	

	@JsonProperty("$user_email")
	private String userEmail;
	
	/**
	 * Provide the full name of the user here. Concatenate first name and last name together if you collect 
	 * them separately in your system.
	 */
	@JsonProperty("$name")
	private String name;
	
	/**
	 * The primary phone number of the user associated with this account. Provide the phone number as a string, 
	 * starting with the country code. For example: "1-415-555-6041".
	 */
	@JsonProperty("$phone")
	private String phone;
	
	/**
	 * The ID of the user that referred the current user to your business. This field is required for detecting 
	 * referral fraud. Note: User IDs are case sensitive. You may need to normalize the capitalization of your 
	 * user IDs.
	 */
	@JsonProperty("$referrer_user_id")
	private String referrerUserId;
	
	/**
	 * The payment information associated with this order. Represented as an array of nested {@link PaymentMethod} 
	 * objects containing payment type, payment gateway, credit card bin, etc.
	 */
	@JsonProperty("$payment_methods")
	private PaymentMethod[] paymentMethods;
	
	/**
	 * The billing address as entered by the user. Represented as a nested {@link Address} object.
	 */
	@JsonProperty("$billing_address")
	private Address billingAddress;
	
	/**
	 * Provide the name of the social identity provider (e.g., $twitter, $facebook) in this field if the user 
	 * uses them to log in to their account.
	 */
	@JsonProperty("$social_sign_on_type")
	private SocialSignOnType socialSignOnType;
	
	
	public CreateAccount() {
		super("$create_account");
	}
	

	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}


	public String getReferrerUserId() {
		return referrerUserId;
	}


	public PaymentMethod[] getPaymentMethods() {
		return paymentMethods;
	}


	public Address getBillingAddress() {
		return billingAddress;
	}

	public SocialSignOnType getSocialSignOnType() {
		return socialSignOnType;
	}


	public CreateAccount setUserId(String userId) {
		this.userId = userId;
		return this;
	}


	public CreateAccount setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}


	public CreateAccount setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}


	public CreateAccount setName(String name) {
		this.name = name;
		return this;
	}


	public CreateAccount setPhone(String phone) {
		this.phone = phone;
		return this;
	}


	public CreateAccount setReferrerUserId(String referrerUserId) {
		this.referrerUserId = referrerUserId;
		return this;
	}


	public CreateAccount setPaymentMethods(PaymentMethod[] paymentMethods) {
		this.paymentMethods = paymentMethods;
		return this;
	}


	public CreateAccount setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}


	public CreateAccount setSocialSignOnType(SocialSignOnType socialSignOnType) {
		this.socialSignOnType = socialSignOnType;
		return this;
	}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((billingAddress == null) ? 0 : billingAddress.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Arrays.hashCode(paymentMethods);
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result
                + ((referrerUserId == null) ? 0 : referrerUserId.hashCode());
        result = prime * result
                + ((sessionId == null) ? 0 : sessionId.hashCode());
        result = prime
                * result
                + ((socialSignOnType == null) ? 0 : socialSignOnType.hashCode());
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

        if (obj == null || !(obj instanceof CreateAccount)) {
            return false;
        }
        
        final CreateAccount ca = (CreateAccount)obj;
        
        if (this.billingAddress == null) {
            if (ca.getBillingAddress() != null) {
                return false;
            }
        } else if (!this.billingAddress.equals(ca.getBillingAddress())) {
            return false;
        }
        
        if (this.name == null) {
            if (ca.getName() != null) {
                return false;
            }
        } else if (!this.name.equals(ca.getName())) {
            return false;
        }
        
        if (this.paymentMethods == null) {
            if (ca.getPaymentMethods() != null) {
                return false;
            }
        } else if (!Arrays.equals(this.paymentMethods, ca.getPaymentMethods())) {
            return false;
        }
        
        if (this.phone == null) {
            if (ca.getPhone() != null) {
                return false;
            }
        } else if (!this.phone.equals(ca.getPhone())) {
            return false;
        }
        
        if (this.referrerUserId == null) {
            if (ca.getReferrerUserId() != null) {
                return false;
            }
        } else if (!this.referrerUserId.equals(ca.getReferrerUserId())) {
            return false;
        }
        
        if (this.sessionId == null) {
            if (ca.getSessionId() != null) {
                return false;
            }
        } else if (!this.sessionId.equals(ca.getSessionId())) {
            return false;
        }
        
        if (this.socialSignOnType == null) {
            if (ca.getSocialSignOnType() != null) {
                return false;
            }
        } else if (!this.socialSignOnType.equals(ca.getSocialSignOnType())) {
            return false;
        }
        
        if (this.userEmail == null) {
            if (ca.getUserEmail() != null) {
                return false;
            }
        } else if (!this.userEmail.equals(ca.getUserEmail())) {
            return false;
        }
        
        if (this.userId == null) {
            if (ca.getUserId() != null) {
                return false;
            }
        } else if (!this.userId.equals(ca.getUserId())) {
            return false;
        }
        
        return true;
        
    }
	
}
