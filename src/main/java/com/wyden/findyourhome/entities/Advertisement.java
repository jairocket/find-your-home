package com.wyden.findyourhome.entities;
import jakarta.persistence.*;

import com.wyden.findyourhome.entities.enums.AdvertisementStatus;
import java.io.Serializable;

@Entity
@Table(name = "ADVERTISEMENT")
public class Advertisement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Costumer customer;


    private AdvertisementStatus status;
}
