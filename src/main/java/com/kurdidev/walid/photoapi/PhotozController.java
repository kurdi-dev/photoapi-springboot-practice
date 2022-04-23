package com.kurdidev.walid.photoapi;

import java.io.IOException;
import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotozController {

    private final PhotozService photozService;
    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }


    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/photoz")
    public Collection<Photo> getPhotos() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo getPhoto(@PathVariable String id) {
        return photozService.getById(id);
    }

    @PostMapping("/photoz")
    public Photo postPhoto(@RequestPart("file") MultipartFile file) throws IOException{
        return  photozService.postPhoto(file);
    }

    @DeleteMapping("/photoz/{id}")
    public void deletePhoto(@PathVariable String id) {
        photozService.deletePhoto(id);
    }
    
    
}
