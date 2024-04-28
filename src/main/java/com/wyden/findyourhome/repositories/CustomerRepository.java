package com.wyden.findyourhome.repositories;
import com.wyden.findyourhome.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
