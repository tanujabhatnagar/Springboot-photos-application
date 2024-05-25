package com.jetbrains.tanuja.photos_clone.repository;

import com.jetbrains.tanuja.photos_clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {
}
