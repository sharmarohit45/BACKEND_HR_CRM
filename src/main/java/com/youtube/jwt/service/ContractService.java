package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.dao.ContractDao;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Contracts;

@Service
public class ContractService {
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ClientDao clientDao;

	public List<Contracts> getAllContracts() {
		
		return contractDao.findAll();
	}

	public Contracts saveContract(Contracts contract) {
		Client client = clientDao.findById(contract.getClientIId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
                contract.setClient(client);
        return contractDao.save(contract);
    }
	
}