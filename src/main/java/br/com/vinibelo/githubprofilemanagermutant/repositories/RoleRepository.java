package br.com.vinibelo.githubprofilemanagermutant.repositories;

import br.com.vinibelo.githubprofilemanagermutant.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsRolesByName(String name);

    Role findByName(String name);
}
