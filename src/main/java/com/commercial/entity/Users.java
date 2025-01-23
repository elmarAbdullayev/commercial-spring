package com.commercial.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private long password;

   // mappedBy = "user" kısmı, Bestellung sınıfında user isimli bir alanın bu ilişkiyi yönettiğini belirtir.mappedBy iki tarafli iliskilerde hangi tarafin iliskiyi yonettigi temsil eder.
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL) // cascade = CascadeType.ALL heißt  Änderungen an einem Benutzer (z. B. Speichern oder Löschen) wirken sich automatisch auf die zugehörigen Bestellungen aus (z. B. sie werden ebenfalls gespeichert oder gelöscht). Yeni user silinende Produkt klassindada oda aid olanlar silinir.
    private List<Bestellung> bestellungen;  // Bunun ücün ayrica bir sütun olusturulmur mappedBy sahesinde. Cünki bunun bestellung tablosunda . Yeni bunun sahesinde bestellungdanda bu liste ulasabiliriz. // Bir userin tüm Bestellunglari burada tutulur ve hepsine kolay sekilde erisebiliyoruz.



}
