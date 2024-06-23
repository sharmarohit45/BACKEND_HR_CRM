package com.youtube.jwt.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProduct() {
		return productDao.findAll();
	}

	public Product saveProduct(Product product) {
		if (product.getDownloadableFile() != null && StringUtils.hasText(product.getDownloadable())) {
            String directoryPath = "src/images/ProductImages";
            String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, product.getDownloadable(), product.getDownloadableFile());
            if (imagePath != null) {
            	product.setDownloadable(imagePath);
            } else {
                // Handle the case where image saving fails
            }
        }
		return productDao.save(product);
	}
	public List<Product> getAllProducts()
	{
		return productDao.findAll();
	}
	public Optional<Product> getProductById(Long productId) {
        Optional<Product> product = productDao.findById(productId);
        return product;
    }
	public void deleteById(Long productId) {
        productDao.deleteById(productId);
    }

}