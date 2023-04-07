package com.example.dyplom.utils;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
@AllArgsConstructor
public class FileUtil {
    public final String destFolder = "images/";
    public final static String userImagesFolder = "user-images/";
    public final static String movieImagesFolder = "movie-images/";
    public final static String movieListImagesFolder = "movie-lists-images/";


    public static String upload(String uploadDir, String filename, MultipartFile file){
        try(InputStream inputStream = file.getInputStream()) {
            Path uploadPath = Paths.get(uploadDir);

            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(filename);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}