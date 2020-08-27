package cl.awake.simulacro.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.awake.simulacro.modelos.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer>{
	

}
