package com.youtube.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestParam("file") MultipartFile file,
			@RequestParam("addImage") MultipartFile addImage, @ModelAttribute Product product) {
		try {
			if (!file.isEmpty()) {
				byte[] downloadableFile = file.getBytes();
				product.setDownloadableFile(downloadableFile);
				product.setDownloadable(file.getOriginalFilename());
			}
			if (!addImage.isEmpty()) {
				byte[] addImages = addImage.getBytes();
				product.setAddImages(addImages);
				product.setImageName(addImage.getOriginalFilename());
			}
			Product savedProduct = productService.saveProduct(product);
			return ResponseEntity.ok(savedProduct);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> getClientById(@PathVariable Long productId) {
		Optional<Product> product = productService.getProductById(productId);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long productId) {
        productService.deleteById(productId);
        return ResponseEntity.noContent().build();
    }
}
