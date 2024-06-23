package com.youtube.jwt.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileHandler {

    public static String saveImageDataToFile(String directoryPath, String imageName, byte[] imageData) {
        String imagePath = directoryPath + File.separator + imageName;
        File imageFile = new File(imagePath);
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            fos.write(imageData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            return null; // Return null if there's an error saving the image
        }
        return imagePath; // Return the file path where the image data is stored
    }
}
