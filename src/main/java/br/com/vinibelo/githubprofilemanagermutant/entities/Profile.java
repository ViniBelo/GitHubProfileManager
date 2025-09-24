package br.com.vinibelo.githubprofilemanagermutant.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    @Setter
    @OneToOne
    @JoinColumn(name = "user_id")
    private User owner;

    public Profile(String name,
                   String url) {
        this.name = name;
        this.url = url;
    }
}
