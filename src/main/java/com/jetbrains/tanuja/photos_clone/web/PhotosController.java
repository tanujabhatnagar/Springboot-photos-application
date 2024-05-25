package com.jetbrains.tanuja.photos_clone.web;

import com.jetbrains.tanuja.photos_clone.model.Photo;
import com.jetbrains.tanuja.photos_clone.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/photos")
    public Iterable<Photo> getPhotos(){
        return photosService.getAll();
    }

    //@PathVariable will search for the variable in url and is used to get values from url with same name.
    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable Integer id){
        Photo photo=photosService.get(id);
        if(photo==null)throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photosService.get(id);
    }
    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable Integer id){
        photosService.remove(id);
     //   if(photo==null)throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/photos/add")
    public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.save(file.getOriginalFilename(),file.getBytes(),file.getContentType());
    }
}
