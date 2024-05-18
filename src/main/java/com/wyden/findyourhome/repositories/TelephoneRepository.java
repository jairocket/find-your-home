package com.wyden.findyourhome.repositories;

import com.wyden.findyourhome.entities.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long>{
    
    @Query("SELECT t FROM Telephone t WHERE t.mainNumber = TRUE AND t.costumer.id = :costumerId")
    Telephone findMainNumberByCostumerId(@Param("costumerId") Long costumerId);

}
