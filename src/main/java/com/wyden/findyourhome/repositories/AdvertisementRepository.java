package com.wyden.findyourhome.repositories;

import com.wyden.findyourhome.entities.Advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long>{
}