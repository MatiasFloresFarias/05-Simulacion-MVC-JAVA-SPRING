package cl.awake.simulacro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.awake.simulacro.modelos.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

}
