package com.youtube.jwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.dao.ProposalProductRepository;
import com.youtube.jwt.dao.ProposalRepository;
import com.youtube.jwt.entity.Proposal;
import com.youtube.jwt.entity.ProposalProduct;
import com.youtube.jwt.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;

@RestController
public class ProposalController {
	@Autowired
    private ProposalService proposalService;
	 private static final Logger logger = LoggerFactory.getLogger(ProposalController.class);
	 
	 @PostMapping("/proposals")
	 public Proposal handleProposal(@RequestBody Proposal proposal) {
	        // Process the proposal object
	        for (ProposalProduct product : proposal.getProposalProducts()) {
	            if (product.getFileData() != null) {
	                saveImage(product.getFileData(), product.getFileName());
	            }
	        }

	        // Example modification
	        proposal.setDescription("Updated description");
	        proposal.setCurrency("USD");
	        proposal.setValidTill("2024-12-31");

	        // Save the proposal
	        return proposalService.saveProposal(proposal);
	    }

	    private void saveImage(String fileData, String fileName) {
	        // Decode base64 file data
	        byte[] decodedBytes = Base64.getDecoder().decode(fileData);
	        try {
	            // Define the path where the image will be saved
	            java.nio.file.Path path = java.nio.file.Paths.get("src/images/ClientLogoImages" + (fileName != null ? fileName : "output_image.png"));
	            // Ensure the directory exists
	            java.nio.file.Files.createDirectories(path.getParent());
	            // Write the decoded bytes to the file
	            java.nio.file.Files.write(path, decodedBytes);
	            System.out.println("Image data has been written to " + path.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	/**@PostMapping("/proposals")
	public Proposal createProposal(@ModelAttribute Proposal proposal,
	                               @RequestParam(name = "proposalProductFiles", required = false) List<MultipartFile> proposalProductFiles) throws IOException {

	    // Ensure the proposalProducts list is initialized
	    if (proposal.getProposalProducts() == null) {
	        proposal.setProposalProducts(new ArrayList<>());
	    }
	  

	    // Initialize an empty list to hold the proposal products
	    List<ProposalProduct> proposalProducts = new ArrayList<>();

	    // Iterate over each productDTO in the proposal
	    for (ProposalProduct productDTO : proposal.getProposalProducts()) {
	        ProposalProduct product = new ProposalProduct();
	        product.setDescription(productDTO.getDescription());
	        product.setQuantity(productDTO.getQuantity());
	        product.setUnitPrice(productDTO.getUnitPrice());
	        product.setTax(productDTO.getTax());
	        product.setAmount(productDTO.getAmount());
	        
	        // Find the corresponding file for this product (assuming index-based matching)
	        	
	            int index = proposal.getProposalProducts().indexOf(productDTO);
	            logger.info("index===="+index);
	           
	            	
	                MultipartFile proposalProductFile = proposalProductFiles.get(index);
	                logger.info("fjfhjhfdjfhd");
	                if (proposalProductFile != null && !proposalProductFile.isEmpty()) {
	                    try {
	                        byte[] fileData = proposalProductFile.getBytes();
	                        product.setFileData(fileData);
	                        product.setFileName(proposalProductFile.getOriginalFilename());
	                    } catch (IOException e) {
	                        e.printStackTrace(); // Handle properly in your application
	                    }
	                }

	        // Add the product to the list
	        proposalProducts.add(product);
	    }

	    // Set the proposal products to the proposal object
	    proposal.setProposalProducts(proposalProducts);

	    // Save the proposal using the proposal service
	    return proposalService.saveProposal(proposal);
	}**/


}
