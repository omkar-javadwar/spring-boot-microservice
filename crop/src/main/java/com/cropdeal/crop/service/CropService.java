package com.cropdeal.crop.service;

import java.util.List;

import com.cropdeal.crop.model.Crop;

public interface CropService{

    public List<Crop> viewCrops();

	Crop viewCrop(String _id);
	
	public Crop addCrop(Crop crop);
	
	public Crop updateCrop(Crop crop, String cropId);

	String deleteCrop(String _id);

}