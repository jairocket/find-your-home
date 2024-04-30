package com.wyden.findyourhome.repositories;

import com.wyden.findyourhome.entities.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long>{
    
}
