package cl.awake.simulacro.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.simulacro.modelos.Comments;
import cl.awake.simulacro.modelos.Posts;
import cl.awake.simulacro.repositorios.CommentsRepository;
import cl.awake.simulacro.repositorios.PostsRepository;

@Controller
public class CommentsController {

	@Autowired
	CommentsRepository cr;

	@Autowired
	PostsRepository pr;

	@RequestMapping(value = "/cargaComments", method = RequestMethod.GET)
	public ModelAndView getAllPostJSON(Model model, HttpServletRequest request) {

		// Ruta del  api rest comments  
		final String uri = "https://jsonplaceholder.typicode.com/comments";
		// Intanciar RestTemplate 
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Comments>> postResponse = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Comments>>() {
				});
		
		//Obtener comments  
		List<Comments> lista = postResponse.getBody();
		model.addAttribute("comments", lista);
		System.out.println("Cantidad: " + lista.size());
		
		// guardar en bbdd
		List<Comments> cs = new ArrayList<>();
		
		// recorremos los datos y guardamos en nuestra base de datos
		for (Comments comments : lista) {
			int postId = comments.getPostId();
			Optional<Posts> post = pr.findById(postId);
			comments.setPost(post.get());
			 cs.add(comments);
		}
		//guardamos todos  
		cr.saveAll(cs);
		System.out.println("carga de comments exitosa");
		
		//redireccionamos a Listar 
		return new ModelAndView("redirect:/listarPosts", "model", model);
	}

	@RequestMapping(value = "/listarComments/{idPost}", method = RequestMethod.GET)
	public ModelAndView listarPosts(@PathVariable("idPost") int idPost) {
		
		Optional<Posts> post = pr.findById(idPost);
		Set<Comments> lista = post.get().getComments();

		return new ModelAndView("listaComments", "lista", lista);
	}

}
