package com.dxc.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document
public class Contact {

		@Id
	 	private String contactId;
	    private String contactName;
	    private String contactEmail;
	    private String contactPhone;
		
	    
	    public String getContactId() {
	        return contactId;
	    }

	    public void setContactId(String contactId) {
	        this.contactId = contactId;
	    }

	    public String getContactName() {
	        return contactName;
	    }

	    public void setContactName(String contactName) {
	        this.contactName = contactName;
	    }

	    public String getContactEmail() {
	        return contactEmail;
	    }

	    public void setContactEmail(String contactEmail) {
	        this.contactEmail = contactEmail;
	    }

	    public String getContactPhone() {
	        return contactPhone;
	    }

	    public void setContactPhone(String contactPhone) {
	        this.contactPhone = contactPhone;
	    }

	    @Override
	    public String toString() {
	        return "Contact{" +
	                "contactId='" + contactId + '\'' +
	                ", contactName='" + contactName + '\'' +
	                ", contactEmail='" + contactEmail + '\'' +
	                ", contactPhone='" + contactPhone + '\'' +
	                '}';
	    }
	
	    
	    
	    
}
