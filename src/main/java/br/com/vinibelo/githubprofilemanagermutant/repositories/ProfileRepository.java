package br.com.vinibelo.githubprofilemanagermutant.repositories;

import br.com.vinibelo.githubprofilemanagermutant.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, BigInteger> { }
