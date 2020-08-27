package cl.awake.simulacro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.awake.simulacro.modelos.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {

}
