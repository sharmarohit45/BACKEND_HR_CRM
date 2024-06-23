package com.youtube.jwt.dao;

import org.springframework.data.repository.CrudRepository;

import com.youtube.jwt.entity.Client;

public interface ClientDao extends CrudRepository<Client, Long> {
    Client findByEmail(String email);
   
	 
	 
}