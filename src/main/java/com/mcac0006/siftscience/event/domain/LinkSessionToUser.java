/**
 * 
 */
package com.mcac0006.siftscience.event.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Use {@link LinkSessionToUser} to associate data from a specific session to a user. 
 * Generally used only in anonymous checkout workflows.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class LinkSessionToUser extends Event {
	
	/**
	 * The user's current session ID, used to tie a user's action before and after log in or account creation.
	 */
	@JsonProperty("$session_id")
	private String sessionId;
	
	/**
	 * The user's account ID according to your systems. Use the same ID that you would use to look up users 
	 * on your website's databases. This field is required on all events performed by the user while logged in. 
	 * Users without an assigned {@link #userId} will not show up in the console. Note: User IDs are 
	 * <strong>case sensitive</strong>. You may need to normalize the capitalization of your user IDs.
	 */
	@JsonProperty("$user_id")
	private String userId;
	
	public LinkSessionToUser() {
		super("$link_session_to_user");
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public LinkSessionToUser setSessionId(String sessionId) {
		this.sessionId = sessionId;
		return this;
	}

	public LinkSessionToUser setUserId(String userId) {
		this.userId = userId;
		return this;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((sessionId == null) ? 0 : sessionId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (!super.equals(obj)) {
            return false;
        }

        if (obj == null || !(obj instanceof LinkSessionToUser)) {
            return false;
        }
        
        final LinkSessionToUser lstu = (LinkSessionToUser)obj;
        
        if (this.sessionId == null) {
            if (lstu.getSessionId() != null) {
                return false;
            }
        } else if (!this.sessionId.equals(lstu.getSessionId())) {
            return false;
        }
        
        if (this.userId == null) {
            if (lstu.getUserId() != null) {
                return false;
            }
        } else if (!this.userId.equals(lstu.getUserId())) {
            return false;
        }
        
        return true;
    }

}
