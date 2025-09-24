package br.com.vinibelo.githubprofilemanagermutant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String name;
    @Getter
    private String url;
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    public Profile(String name,
                   String url) {
        this.name = name;
        this.url = url;
    }
}
