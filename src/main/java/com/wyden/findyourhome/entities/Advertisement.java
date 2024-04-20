package com.wyden.findyourhome.entities;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.wyden.findyourhome.entities.enums.AdvertisementStatus;
import java.io.Serializable;

@Entity
@Table(name = "ADVERTISEMENT")
public class Advertisement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "post_date")
    private LocalDateTime postDate;

    @Column(name = "value", precision=10, scale=2)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AdvertisementStatus status;

    @Column(name = "sold_in")
    private LocalDateTime soldIn;

    @Column(name = "deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "advertisement", cascade = CascadeType.ALL)
    private List<FavoriteAds> favoriteAds;


    public Advertisement(
        int id, 
        Costumer costumer, 
        Property property, 
        LocalDateTime postDate, 
        BigDecimal value, 
        AdvertisementStatus status, 
        LocalDateTime soldIn, 
        Boolean deleted, 
        List<FavoriteAds> favoriteAds
    ) {
        this.id = id;
        this.costumer = costumer;
        this.property = property;
        this.postDate = postDate;
        this.value = value;
        this.status = status;
        this.soldIn = soldIn;
        this.deleted = deleted;
        this.favoriteAds = favoriteAds;
    }


    public Advertisement() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return this.costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Property getProperty() {
        return this.property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public LocalDateTime getPostDate() {
        return this.postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public AdvertisementStatus getStatus() {
        return this.status;
    }

    public void setStatus(AdvertisementStatus status) {
        this.status = status;
    }

    public LocalDateTime getSoldIn() {
        return this.soldIn;
    }

    public void setSoldIn(LocalDateTime soldIn) {
        this.soldIn = soldIn;
    }

    public Boolean isDeleted() {
        return this.deleted;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<FavoriteAds> getFavoriteAds() {
        return this.favoriteAds;
    }

    public void setFavoriteAds(List<FavoriteAds> favoriteAds) {
        this.favoriteAds = favoriteAds;
    }

}
