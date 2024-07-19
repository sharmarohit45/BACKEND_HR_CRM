package com.youtube.jwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.dao.ProposalProductRepository;
import com.youtube.jwt.dao.ProposalRepository;
import com.youtube.jwt.entity.Product;
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
		List<ProposalProduct> proposalProducts = proposal.getProposalProducts();

		// Ensure the proposal reference is set on each product
		for (ProposalProduct product : proposalProducts) {
			product.setProposal(proposal);
		}

		return proposalService.saveProposal(proposal);
	}

	@GetMapping("/proposals/{proposalId}")
	public ResponseEntity<Proposal> getProposalById(@PathVariable Long proposalId) {
		Proposal proposal = proposalService.getProposalById(proposalId);
		return ResponseEntity.ok(proposal);
	}

	/**
	 * @PostMapping("/proposals") public Proposal handleProposal(@RequestBody
	 * Proposal proposal) { // Process the proposal object List<ProposalProduct>
	 * proposalProducts = new ArrayList<>(); for (ProposalProduct productDTO :
	 * proposal.getProposalProducts()) { ProposalProduct product = new
	 * ProposalProduct(); if (productDTO.getFileData() != null) { //
	 * saveImage(productDTO.getFileData(), productDTO.getFileName());
	 * product.setFileData(productDTO.getFileData());
	 * product.setFileName(productDTO.getFileName()); }
	 * product.setDescription(productDTO.getDescription());
	 * product.setQuantity(productDTO.getQuantity());
	 * product.setUnitPrice(productDTO.getUnitPrice());
	 * product.setTax(productDTO.getTax());
	 * product.setAmount(productDTO.getAmount()); proposalProducts.add(product); }
	 * proposal.setProposalProducts(proposalProducts);
	 * 
	 * 
	 * return proposalService.saveProposal(proposal); }
	 **/

	/**
	 * @PostMapping("/proposals") public Proposal createProposal(@ModelAttribute
	 * Proposal proposal,
	 * 
	 * @RequestParam(name = "proposalProductFiles", required = false)
	 *                    List<MultipartFile> proposalProductFiles) throws
	 *                    IOException {
	 * 
	 *                    // Ensure the proposalProducts list is initialized if
	 *                    (proposal.getProposalProducts() == null) {
	 *                    proposal.setProposalProducts(new ArrayList<>()); }
	 * 
	 * 
	 *                    // Initialize an empty list to hold the proposal products
	 *                    List<ProposalProduct> proposalProducts = new
	 *                    ArrayList<>();
	 * 
	 *                    // Iterate over each productDTO in the proposal for
	 *                    (ProposalProduct productDTO :
	 *                    proposal.getProposalProducts()) { ProposalProduct product
	 *                    = new ProposalProduct();
	 *                    product.setDescription(productDTO.getDescription());
	 *                    product.setQuantity(productDTO.getQuantity());
	 *                    product.setUnitPrice(productDTO.getUnitPrice());
	 *                    product.setTax(productDTO.getTax());
	 *                    product.setAmount(productDTO.getAmount());
	 * 
	 *                    // Find the corresponding file for this product (assuming
	 *                    index-based matching)
	 * 
	 *                    int index =
	 *                    proposal.getProposalProducts().indexOf(productDTO);
	 *                    logger.info("index===="+index);
	 * 
	 * 
	 *                    MultipartFile proposalProductFile =
	 *                    proposalProductFiles.get(index);
	 *                    logger.info("fjfhjhfdjfhd"); if (proposalProductFile !=
	 *                    null && !proposalProductFile.isEmpty()) { try { byte[]
	 *                    fileData = proposalProductFile.getBytes();
	 *                    product.setFileData(fileData);
	 *                    product.setFileName(proposalProductFile.getOriginalFilename());
	 *                    } catch (IOException e) { e.printStackTrace(); // Handle
	 *                    properly in your application } }
	 * 
	 *                    // Add the product to the list
	 *                    proposalProducts.add(product); }
	 * 
	 *                    // Set the proposal products to the proposal object
	 *                    proposal.setProposalProducts(proposalProducts);
	 * 
	 *                    // Save the proposal using the proposal service return
	 *                    proposalService.saveProposal(proposal); }
	 **/

	@GetMapping("/proposals")
	public List<Proposal> getAllProducts() {
		return proposalService.getAllProjects();
	}

}
