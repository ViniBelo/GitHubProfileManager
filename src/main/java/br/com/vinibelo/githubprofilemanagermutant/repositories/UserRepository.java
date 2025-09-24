package br.com.vinibelo.githubprofilemanagermutant.repositories;

import br.com.vinibelo.githubprofilemanagermutant.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByLogin(String login);
}
