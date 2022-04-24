package com.kurdidev.walid.photoapi.service;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.kurdidev.walid.photoapi.model.Photo;
import com.kurdidev.walid.photoapi.repository.PhotozRepository;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PhotozService {

    private final PhotozRepository photozRepository;
    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    

    public Iterable<Photo> get() {
       return photozRepository.findAll();
    }

    public Photo getById(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public Photo postPhoto(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setFileName(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        photo.setData(file.getBytes());
        photozRepository.save(photo);
        return photo;
    }

    public void deletePhoto(Integer id) {
        photozRepository.deleteById(id);
    }

    public ResponseEntity<byte[]> downloadPhoto(Integer id) {
        Photo photo = this.getById(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        byte[] data =  photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment")
                                                    .filename(photo.getFileName())
                                                    .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    
    
}
