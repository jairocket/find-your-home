package com.wyden.findyourhome.controllers;

import com.wyden.findyourhome.dto.CreateAdvertisementDTO;
import com.wyden.findyourhome.dto.DeleteAdvertisementImageDTO;
import com.wyden.findyourhome.dto.UpdateAdversementDTO;
import com.wyden.findyourhome.dto.UpdateStatusDTO;
import com.wyden.findyourhome.entities.Costumer;
import com.wyden.findyourhome.entities.Property;
import com.wyden.findyourhome.entities.enums.AdvertisementStatus;
import com.wyden.findyourhome.exceptions.AdvertisementException;
import com.wyden.findyourhome.services.CostumerService;
import com.wyden.findyourhome.services.ImageService;
import com.wyden.findyourhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wyden.findyourhome.entities.Advertisement;
import com.wyden.findyourhome.services.AdvertisementService;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;

@RestController
@RequestMapping(value = "/advertisements")
public class AdvertisementController {

    @Autowired
    private AdvertisementService service;

    @Autowired
    private CostumerService costumerService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Advertisement> create(@RequestBody CreateAdvertisementDTO createAdvertisementDTO) {

        Costumer costumer = costumerService.findById(createAdvertisementDTO.getCostumerId());
        Property property = propertyService.findById(createAdvertisementDTO.getPropertyId());

        Advertisement advertisement = new Advertisement(
                costumer,
                AdvertisementStatus.ACTIVE,
                property,
                Instant.now(),
                createAdvertisementDTO.getValue(),
                null,
                createAdvertisementDTO.getDescription()
        );

        Advertisement createdAdvertisement = service.create(advertisement);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(createdAdvertisement.getId()).toUri();

        return ResponseEntity.created(uri).body(createdAdvertisement);

    }

    @PutMapping
    public ResponseEntity<Advertisement> update(@RequestBody UpdateAdversementDTO updateAdversementDTO) {
        Advertisement advertisement = service.findById(updateAdversementDTO.getId());

        advertisement.setDescription(updateAdversementDTO.getDescription());
        advertisement.setValue(updateAdversementDTO.getValue());

        Advertisement updatedAdvertisement = service.update(advertisement);

        return ResponseEntity.ok().body(updatedAdvertisement);
    }
   
    @PutMapping(value = "/{id}")
    public ResponseEntity<Advertisement> updateSoldStatus(@PathVariable Long id) {
        Advertisement advertisement = service.findById(id);

        advertisement.setStatus(AdvertisementStatus.SOLD);
        advertisement.setSoldIn(Instant.now());
        Advertisement updatedAdvertisement = service.update(advertisement);

        return ResponseEntity.ok().body(updatedAdvertisement);
    }

    @PutMapping(value = "/status")
    public ResponseEntity<Advertisement> updateStatus(@RequestBody UpdateStatusDTO updateStatusDTO) {
        Advertisement advertisement = service.findById(updateStatusDTO.getId());

        if(updateStatusDTO.getStatus().equals("SOLD")) {
            throw new AdvertisementException("Ação inválida");
        }

        advertisement.setStatus(AdvertisementStatus.valueOf(updateStatusDTO.getStatus()));
        Advertisement updatedAdvertisement = service.update(advertisement);

        return ResponseEntity.ok().body(updatedAdvertisement);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Advertisement> findById(@PathVariable Long id){
        Advertisement advertisement = service.findById(id);
        
        return ResponseEntity.ok().body(advertisement);
    }

    @GetMapping
    public ResponseEntity<List<Advertisement>> findAll(@RequestParam(required = false) AdvertisementStatus status) {
        java.util.List<Advertisement> advertisement = service.findAll(status);
        return ResponseEntity.ok().body(advertisement);
    }

    @PostMapping("/images/{id}")
    public ResponseEntity<Advertisement> save(@RequestParam("image") List<MultipartFile> images, @PathVariable Long id) {
        List<String> savedImagePaths = images.stream().map((image)-> imageService.save(image).toString()).toList();
        Advertisement advertisement = service.findById(id);
        List<String> advertisementImages = advertisement.getImages();
        advertisementImages.addAll(savedImagePaths);
        advertisement.setImages(advertisementImages);

        Advertisement updatedAdvertisement = service.update(advertisement);
        return ResponseEntity.ok().body(updatedAdvertisement);
    }

    @DeleteMapping("images/delete")
    public ResponseEntity<Advertisement> delete(@RequestBody DeleteAdvertisementImageDTO deleteImageDTO) {
        Advertisement advertisement = service.findById(deleteImageDTO.advertisementId);

        if (advertisement == null) {
            throw new AdvertisementException("Não foi possível deletar esta imagem");
        }

        imageService.deleteImage(deleteImageDTO.imageName);
        String imageDiretory = imageService.getImageDirectoryByName(deleteImageDTO.imageName);

        List<String> advertisementImages = advertisement.getImages();
        advertisementImages.remove(imageDiretory);
        advertisement.setImages(advertisementImages);

        Advertisement updatedAdvertisement = service.update(advertisement);

        return ResponseEntity.ok().body(updatedAdvertisement);

    }
}