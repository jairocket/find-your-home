package com.wyden.findyourhome.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "FAVORITE_ADS")
public class FavoriteAds {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;


    public FavoriteAds(
        Person person, 
        Advertisement advertisement
    ) {
        this.person = person;
        this.advertisement = advertisement;
    }


    public FavoriteAds() {
    }


    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Advertisement getAdvertisement() {
        return this.advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

}
