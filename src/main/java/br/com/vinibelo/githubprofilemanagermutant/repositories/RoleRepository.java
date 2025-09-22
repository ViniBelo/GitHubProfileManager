package br.com.vinibelo.githubprofilemanagermutant.repositories;

import br.com.vinibelo.githubprofilemanagermutant.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RoleRepository extends JpaRepository<Role, BigInteger> { }
