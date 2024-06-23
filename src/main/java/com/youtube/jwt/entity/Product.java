package com.youtube.jwt.entity;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String type;
	private String name;
	private String sku;
	private String unitType;
	private String productCategory;
	private String productSubCategory;
	private String sellingPrice;
	private String costPrice;
	private String tax;
	private String hsnSac;
	private String clientCanPurchase;
	private String downloadable;

	@Lob 
	private byte[] downloadableFile;
	private String trackInventory;
	private String openingStocks;
	private String additionalNotes;
	private String inlineRadioOptions;
	private String imageName;
	@Lob
	private byte[] addImages;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getHsnSac() {
		return hsnSac;
	}
	public void setHsnSac(String hsnSac) {
		this.hsnSac = hsnSac;
	}
	public String getClientCanPurchase() {
		return clientCanPurchase;
	}
	public void setClientCanPurchase(String clientCanPurchase) {
		this.clientCanPurchase = clientCanPurchase;
	}
	public String getDownloadable() {
		return downloadable;
	}
	public void setDownloadable(String downloadable) {
		this.downloadable = downloadable;
	}
	public byte[] getDownloadableFile() {
		return downloadableFile;
	}
	public void setDownloadableFile(byte[] downloadableFile) {
		this.downloadableFile = downloadableFile;
	}
	public String getTrackInventory() {
		return trackInventory;
	}
	public void setTrackInventory(String trackInventory) {
		this.trackInventory = trackInventory;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public String getInlineRadioOptions() {
		return inlineRadioOptions;
	}
	public void setInlineRadioOptions(String inlineRadioOptions) {
		this.inlineRadioOptions = inlineRadioOptions;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public byte[] getAddImages() {
		return addImages;
	}
	public void setAddImages(byte[] addImages) {
		this.addImages = addImages;
	}
	public String getOpeningStocks() {
		return openingStocks;
	}
	public void setOpeningStocks(String openingStocks) {
		this.openingStocks = openingStocks;
	}
	
}
