package com.court.management.controller;

import com.court.management.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@Slf4j
public class ImageController {

    @Autowired
    private ImageService service;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file , @RequestParam(name = "email") String email ,@RequestParam(name = "name") String name){
        log.info("file , {} , email , {} , name , {} ", file.getName(),email,name);
        String uploadImage = service.uploadImage(file, email, name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{id}/{name}")
    public ResponseEntity<?> downloadImage(@PathVariable(name = "id") long id ,@PathVariable(name = "name") String name){
        byte[] imageData=service.downloadImage(id,name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_JPEG)
                .contentType(MediaType.IMAGE_PNG)
                .body(imageData);

    }
}
