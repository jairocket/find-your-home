package com.wyden.findyourhome.entities;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FAVORITE_ADS")
public class FavoriteAds implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @Id
    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;


    public FavoriteAds(
        Costumer costumer, 
        Advertisement advertisement
    ) {
        this.costumer = costumer;
        this.advertisement = advertisement;
    }


    public FavoriteAds() {
    }


    public Costumer getCostumer() {
        return this.costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Advertisement getAdvertisement() {
        return this.advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

}
