package com.court.management.serviceImpl;

import com.court.management.exception.CourtException;
import com.court.management.model.SignUp;
import com.court.management.repo.SignUpRepoWork;
import com.court.management.service.ImageService;
import com.court.management.utils.ImageUtil;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
    @Autowired
    private SignUpRepoWork repository;
@Override
    public String uploadImage(MultipartFile file,String email,String name) {

try {
    SignUp signUp = repository.findByEmail(email).get();
    if (name.contains("gid")) {
        signUp.setGovtIdProff(ImageUtil.compressImage(file.getBytes()));
    } else if (name.contains("cert")) {
        signUp.setLawCertficate(ImageUtil.compressImage(file.getBytes()));
    }

    SignUp save = repository.save(signUp);

    if (save != null) {
        return "file uploaded successfully : " + file.getOriginalFilename();
    }
    return null;
}catch (Exception e)
{
    log.error(e.toString());
    throw  new CourtException(e.getMessage());
}
    }

    public byte[] downloadImage(long id, @NotNull String name){
        SignUp signUp = repository.findById(id).get();
        byte[] images;
        if(name.contains("gid"))
        {
            images = ImageUtil.decompressImage(signUp.getGovtIdProff());
        }else
        {
            images = ImageUtil.decompressImage(signUp.getLawCertficate());
        }

        System.out.println(images.length);
        return images;
    }


}
