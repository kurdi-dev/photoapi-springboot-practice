package com.kurdidev.walid.photoapi;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    private Map<String, Photo> db = new HashMap<>();

    public Collection<Photo> get() {
       return db.values();
    }

    public Photo getById(String id) {
        Photo photo = db.get(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            return photo;
        }
    }

    public Photo postPhoto(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        photo.setData(file.getBytes());
        db.put(photo.getId() ,photo);
        return photo;
    }

    public void deletePhoto(String id) {
        Photo photo = db.remove(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<byte[]> downloadPhoto(String id) {
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
