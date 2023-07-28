package com.dxc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Sort;
import com.dxc.dao.ContactDAO;
import com.dxc.exception.ContactExistsException;
import com.dxc.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;
	
	public Contact addContact(Contact contact) throws ContactExistsException {
		 Optional<Contact> contactNew = contactDAO.findById(contact.getContactId());
		 if(contactNew.isPresent())
	            throw new ContactExistsException();
	        else
	            return contactDAO.save(contact);
	}

	public List<Contact> getAllContacts() {
		 List<Contact> contactList = contactDAO.findAll();
	        if(contactList.size()>0)
	            return contactList;
	        else
	            return null;
	}

	
	public Contact getAllContactByEmail(String email) {
		return contactDAO.findByContactEmail(email).get();
	
	}

	@PutMapping("/updateContact")
	public Contact update(@RequestBody Contact contact) {
		
		
		return contactDAO.save(contact);
	}
	
	@DeleteMapping("/deleteContact/{email}")
	public void delete(@PathVariable String email) {
		contactDAO.deleteById(email);
		
	}

}
