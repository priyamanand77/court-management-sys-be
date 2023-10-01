package com.court.management.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public String uploadImage(MultipartFile file, String email ,String name);

    public byte[] downloadImage(long id , String name);
}
