package com.cropdeal.crop.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("crop")
public class Crop {
	
	private String id;
	private String crop_name;
    private String crop_tag;
    private Integer crop_quantity;
    private Integer crop_price;
    private String crop_description;
    
    public Crop() {
		super();
	}

	public Crop(String crop_name, String crop_tag, Integer crop_quantity, Integer crop_price, String crop_description) {
		super();
		this.crop_name = crop_name;
		this.crop_tag = crop_tag;
		this.crop_quantity = crop_quantity;
		this.crop_price = crop_price;
		this.crop_description = crop_description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrop_name() {
		return crop_name;
	}

	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}

	public String getCrop_tag() {
		return crop_tag;
	}

	public void setCrop_tag(String crop_tag) {
		this.crop_tag = crop_tag;
	}

	public Integer getCrop_quantity() {
		return crop_quantity;
	}

	public void setCrop_quantity(Integer crop_quantity) {
		this.crop_quantity = crop_quantity;
	}

	public Integer getCrop_price() {
		return crop_price;
	}

	public void setCrop_price(Integer crop_price) {
		this.crop_price = crop_price;
	}

	public String getCrop_description() {
		return crop_description;
	}

	public void setCrop_description(String crop_description) {
		this.crop_description = crop_description;
	}

	@Override
	public String toString() {
		return "Crop [id=" + id + ", crop_name=" + crop_name + ", crop_tag=" + crop_tag + ", crop_quantity="
				+ crop_quantity + ", crop_price=" + crop_price + ", crop_description=" + crop_description + "]";
	} 
	
}
