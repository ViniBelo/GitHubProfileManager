package br.com.vinibelo.githubprofilemanagermutant.entities;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;
    private String name;
    private String url;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User owner;
}
