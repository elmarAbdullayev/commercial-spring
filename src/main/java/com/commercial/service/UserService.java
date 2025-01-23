package com.commercial.service;

import com.commercial.entity.Bestellung;
import com.commercial.entity.Produkt;
import com.commercial.entity.Users;
import com.commercial.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Bestellung erstelleBestellung(Users user, Produkt produkt, int menge) {
        Bestellung bestellung = new Bestellung();
        bestellung.setUser(user);
        bestellung.setProdukt(produkt);
        bestellung.setMenge(menge);
        bestellung.setBestelldatum(LocalDateTime.now());
        return userRepository.save(bestellung);
    }

}
