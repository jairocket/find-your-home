package com.wyden.findyourhome.repositories;

import com.wyden.findyourhome.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}
