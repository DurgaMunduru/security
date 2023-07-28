package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.exception.ContactExistsException;
import com.dxc.model.Contact;
import com.dxc.service.ContactService;

@RestController
public class ContactController {
	
	 @GetMapping("/greet")
	    public String welcome(){
	        return "Welcome to DXC";
	    }
	    @Autowired
	    private ContactService contactService;
	    @GetMapping("allContacts")
	    public List<Contact> getContacts(){
	        return contactService.getAllContacts();
	    }
	    @PostMapping("addContact")
	    public ResponseEntity<?> addContact(@RequestBody Contact contact) throws ContactExistsException {
	        return new ResponseEntity<>(contactService.addContact(contact), HttpStatus.CREATED);
	    }

	    @GetMapping("/contacts/{email}")
	    public Contact getContactByEmail(@PathVariable String email){
	        return contactService.getAllContactByEmail(email);
	    }
	    @PutMapping("/updateContact")
		public Contact update(@RequestBody Contact contact) {
			
			
			return contactService.update(contact);
		}
		
		@DeleteMapping("/deleteContact/{email}")
		public void delete(@PathVariable String email) {
			contactService.delete(email);
		}
}
