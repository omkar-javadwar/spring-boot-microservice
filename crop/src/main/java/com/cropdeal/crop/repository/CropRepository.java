package com.cropdeal.crop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.crop.model.Crop;

@Repository
public interface CropRepository extends MongoRepository<Crop, String> {

}
