package com.cropdeal.crop.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.crop.model.Crop;
import com.cropdeal.crop.repository.CropRepository;
import com.mongodb.MongoException;

@Service
public class CropServiceImpl implements CropService {

	@Autowired
	CropRepository cropRepository;

	@Override
	public List<Crop> viewCrops() {
		return cropRepository.findAll();
	}

	@Override
	public Crop viewCrop(String _id) {
		return cropRepository.findById(_id).get();
	}
		
	@Override
	public Crop addCrop(Crop crop) {
		return cropRepository.save(crop);
	}

	@Override
	public Crop updateCrop(Crop crop, String _id) {
		if (cropRepository.findById(_id).isPresent()){
            Crop updatedCrop = cropRepository.findById(_id).get();

            if (Objects.nonNull(crop.getCrop_name()) && !"".equalsIgnoreCase(crop.getCrop_name())) {
                updatedCrop.setCrop_name(crop.getCrop_name());
            }

            if (Objects.nonNull(crop.getCrop_tag()) && !"".equalsIgnoreCase(crop.getCrop_tag())) {
                updatedCrop.setCrop_tag(crop.getCrop_tag());
            }
            
            if (Objects.nonNull(crop.getCrop_price())) {
                updatedCrop.setCrop_price(crop.getCrop_price());
            }
            
            if (Objects.nonNull(crop.getCrop_quantity())) {
                updatedCrop.setCrop_quantity(crop.getCrop_quantity());
            }
            
            if (Objects.nonNull(crop.getCrop_description()) && !"".equalsIgnoreCase(crop.getCrop_description())) {
                updatedCrop.setCrop_description(crop.getCrop_description());
            }

    		return cropRepository.save(updatedCrop);
        }
        else
            throw new MongoException("Record not found");
	}
	
	@Override
	public String deleteCrop(String _id) {
		cropRepository.deleteById(_id);
		return "crop deleted:"+_id;
	}
}
