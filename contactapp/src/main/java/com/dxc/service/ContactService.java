package com.dxc.service;

import java.util.List;

import com.dxc.exception.ContactExistsException;
import com.dxc.model.Contact;


public interface ContactService {
    Contact addContact(Contact contact) throws ContactExistsException;
    List<Contact> getAllContacts();
    Contact getAllContactByEmail(String email);
    public Contact update(Contact contact);
	public void delete(String email);
	

}