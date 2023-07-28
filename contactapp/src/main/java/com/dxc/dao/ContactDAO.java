package com.dxc.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dxc.model.Contact;
@Repository
public interface ContactDAO extends MongoRepository<Contact, String> {

	 Optional<Contact> findByContactEmail(String email);

	
}
