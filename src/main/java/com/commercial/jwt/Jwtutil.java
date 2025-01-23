package com.commercial.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.persistence.Column;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Jwtutil {

    private String secretKey = "secretKey";

     public String generateToken(String username) {
         return Jwts.builder() // Erstellt ein neues JWT-Token
                 .subject(username) // Setzt den "Subject" (z. B. den Benutzernamen) in das Token
                 .issuedAt(new Date()) // Fügt das Erstellungsdatum (aktuelle Zeit) hinzu
                 .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Setzt ein Ablaufdatum (hier: 1 Stunde in die Zukunft)
                 .signWith(SignatureAlgorithm.HS512, secretKey) // Signiert das Token mit einem geheimen Schlüssel und dem Algorithmus HS512
                 .compact();  // Baut das JWT-Token als kompakten String zusammen
     }

    public String extractUsername(String token) {
        return Jwts.parser() // Startet den Prozess, um das Token zu analysieren (parsen).
                .setSigningKey(secretKey) // Setzt den geheimen Schlüssel, mit dem das Token signiert wurde (für die Validierung).
                .build()  // Baut den Parser fertig, um das Token zu entschlüsseln.
                .parseClaimsJws(token) // Überprüft und analysiert das übergebene Token.
                .getBody() // Holt den "Body" (den inhaltlichen Teil) des Tokens.
                .getSubject();  // Extrahiert das "Subject"-Feld (z. B. den Benutzernamen) aus dem Body.
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }


}
