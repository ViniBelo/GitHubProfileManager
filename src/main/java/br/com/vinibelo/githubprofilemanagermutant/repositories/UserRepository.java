package br.com.vinibelo.githubprofilemanagermutant.repositories;

import br.com.vinibelo.githubprofilemanagermutant.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> { }
