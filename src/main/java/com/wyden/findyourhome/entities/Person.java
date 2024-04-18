package com.wyden.findyourhome.entities;
import jakarta.persistence.*;
import java.util.List;

import com.wyden.findyourhome.entities.enums.KindPerson;

@Entity
@Table(name = "PERSON")
public class Person {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;

     private String name;
     private String email;
     private String phone;

     @Column(name = "cpf_cnpj")
     private String cpfCnpj;

     @Enumerated(EnumType.STRING)
     @Column(name = "kind_person")
     private KindPerson kindPerson;

     @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
     private List<Telephone> telephones;

     @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
     private List<Advertisement> advertisements;

     @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
     private List<FavoriteAds> favoriteAdvertisements;


     public Person(
          int id, 
          String name, 
          String email, 
          String phone, 
          String cpfCnpj, 
          KindPerson kindPerson, 
          List<Telephone> telephones, 
          List<Advertisement> advertisements, 
          List<FavoriteAds> favoriteAdvertisements
     ){
          this.id = id;
          this.name = name;
          this.email = email;
          this.phone = phone;
          this.cpfCnpj = cpfCnpj;
          this.kindPerson = kindPerson;
          this.telephones = telephones;
          this.advertisements = advertisements;
          this.favoriteAdvertisements = favoriteAdvertisements;
     }


     public Person() {
     }


     public int getId() {
          return this.id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return this.name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return this.email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPhone() {
          return this.phone;
     }

     public void setPhone(String phone) {
          this.phone = phone;
     }

     public String getCpfCnpj() {
          return this.cpfCnpj;
     }

     public void setCpfCnpj(String cpfCnpj) {
          this.cpfCnpj = cpfCnpj;
     }

     public KindPerson getKindPerson() {
          return this.kindPerson;
     }

     public void setKindPerson(KindPerson kindPerson) {
          this.kindPerson = kindPerson;
     }

     public List<Telephone> getTelephones() {
          return this.telephones;
     }

     public void setTelephones(List<Telephone> telephones) {
          this.telephones = telephones;
     }

     public List<Advertisement> getAdvertisements() {
          return this.advertisements;
     }

     public void setAdvertisements(List<Advertisement> advertisements) {
          this.advertisements = advertisements;
     }

     public List<FavoriteAds> getFavoriteAdvertisements() {
          return this.favoriteAdvertisements;
     }

     public void setFavoriteAdvertisements(List<FavoriteAds> favoriteAdvertisements) {
          this.favoriteAdvertisements = favoriteAdvertisements;
     }


}
