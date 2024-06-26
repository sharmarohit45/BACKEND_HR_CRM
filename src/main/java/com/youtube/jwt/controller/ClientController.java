package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.service.ClientService;

@RestController

public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/client-count")
	public Long getClientCount() {
		return clientService.getClientCount();
	}

	@PostMapping("/client")
	public ResponseEntity<Client> saveClient(@RequestParam("clientLogo") MultipartFile clientLogo,
			@RequestParam("clientProfileImage") MultipartFile clientProfileImage, @ModelAttribute Client client) {
		try {
			if (!clientLogo.isEmpty()) {
				byte[] imageLogoData = clientLogo.getBytes();
				client.setImageLogoData(imageLogoData);
				client.setImageLogo(clientLogo.getOriginalFilename());
			}
			if (!clientProfileImage.isEmpty()) {
				byte[] imageProfileData = clientProfileImage.getBytes();
				client.setImageProfileData(imageProfileData);
				client.setImageProfile(clientProfileImage.getOriginalFilename());
			}
			Client savedClient = clientService.saveClient(client);
			return ResponseEntity.ok(savedClient);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping("/allclient")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	@GetMapping("/client/{clientId}")
	public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
		Optional<Client> client = clientService.getClientById(clientId);
		return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
