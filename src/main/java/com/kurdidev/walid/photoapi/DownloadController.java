package com.kurdidev.walid.photoapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {
    private final PhotozService photozService;
    public DownloadController(PhotozService photozService){
        this.photozService = photozService;
    }
    
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable String id){
        return photozService.downloadPhoto(id);

    }
}
