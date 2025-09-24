package br.com.vinibelo.githubprofilemanagermutant.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;
    private String name;
    private String url;

    public Profile(String name,
                   String url) {
        this.name = name;
        this.url = url;
    }
}
