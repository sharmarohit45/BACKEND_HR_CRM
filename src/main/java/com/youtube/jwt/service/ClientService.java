package com.youtube.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Employee;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Long getClientCount() {
        return clientDao.count();
    }
    public Client saveClient(Client client) {
    	String encodedPassword = passwordEncoder.encode(client.getPassword());
    	client.setPassword(encodedPassword);
    	 if (client.getImageProfileData() != null && StringUtils.hasText(client.getImageProfile())) {
             String directoryPath = "src/images/ClientProfileImages";
             String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, client.getImageProfile(), client.getImageProfileData());
             if (imagePath != null) {
            	 client.setImageProfile(imagePath);
             } else {
                 // Handle the case where image saving fails
             }
         }
    	 if (client.getImageLogoData() != null && StringUtils.hasText(client.getImageLogo())) {
             String directoryPath = "src/images/ClientLogoImages"; // Set your image directory path here
             String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, client.getImageLogo(), client.getImageLogoData());
             if (imagePath != null) {
            	 client.setImageLogo(imagePath);
             } else {
                 // Handle the case where image saving fails
             }
         }
        return clientDao.save(client);
    }
    public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		clientDao.findAll().forEach(clients::add);
		return clients;
	}
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public Optional<Client> getClientById(Long clientId) {
        Optional<Client> client = clientDao.findById(clientId);
        if (client.isEmpty()) {
            //Logger.warning("Employee with ID " + empId + " not found.");
        }
        return client;
    }
}