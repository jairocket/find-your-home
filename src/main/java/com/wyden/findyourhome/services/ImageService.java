package com.wyden.findyourhome.services;

import com.wyden.findyourhome.exceptions.AdvertisementException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageService {

    private final String imageDirectory = "src/main/resources/static/images/ads";
    private final Path path = Path.of(imageDirectory);

    public String save(MultipartFile imageFile) {
        String uniqueFileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
        Path filePath = path.resolve(uniqueFileName);

        if(!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException exception) {
                throw new AdvertisementException("Não foi possível salvar esta imagem.");
            }
        }
        return imageDirectory.concat(uniqueFileName);
    }


    public void deleteImage(String imageDirectory, String imageName) {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            try {
                Files.delete(imagePath);
            } catch (IOException exception) {
                throw new AdvertisementException("Não foi possível apagar esta imagem");
            }
        }
    }

}
