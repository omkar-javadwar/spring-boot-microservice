package com.cropdeal.crop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeal.crop.model.Crop;
import com.cropdeal.crop.service.CropService;

@RestController
public class CropController {

	@Autowired
	private CropService cropService;

	@GetMapping("/crop/all")
	public List<Crop> viewCrops() {
		return cropService.viewCrops();
	}

	@GetMapping("/crop/{id}")
	public Crop viewCrop(@PathVariable("id") String cropId) {
		return cropService.viewCrop(cropId);
	}

	@PostMapping("/crop")
	public Crop addCrop(@RequestBody Crop crop) {
		return cropService.addCrop(crop);
	}
	
	@PutMapping("/crop/{id}")
	public Crop updateCrop(@RequestBody Crop crop, @PathVariable("id") String cropId) {
		return cropService.updateCrop(crop, cropId);
	}
	
	@DeleteMapping("/crop/{id}")
	public String deleteCrop(@PathVariable("id") String cropId) {
		return cropService.deleteCrop(cropId);
	}
}
