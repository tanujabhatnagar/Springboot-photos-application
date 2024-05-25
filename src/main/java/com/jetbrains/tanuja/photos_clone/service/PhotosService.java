package com.jetbrains.tanuja.photos_clone.service;

import com.jetbrains.tanuja.photos_clone.model.Photo;
import com.jetbrains.tanuja.photos_clone.repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotosService {

    @Autowired
    private PhotosRepository photosRepository;

    public Iterable<Photo> getAll() {
        return photosRepository.findAll();
    }

    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public Photo save(String fileName, byte[] data, String contentType) {
        Photo photo=new Photo();
        photo.setContentType(contentType);
       // photo.setId(UUID.randomUUID());
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }
}
