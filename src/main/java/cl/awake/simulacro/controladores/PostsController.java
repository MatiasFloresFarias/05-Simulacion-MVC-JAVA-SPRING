package cl.awake.simulacro.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import cl.awake.simulacro.modelos.Posts;
import cl.awake.simulacro.modelos.Users;
import cl.awake.simulacro.repositorios.CommentsRepository;
import cl.awake.simulacro.repositorios.PostsRepository;
import cl.awake.simulacro.repositorios.UsersRepository;


@Controller
public class PostsController {
	
	@Autowired
	PostsRepository pr;
	
	@Autowired
	UsersRepository ur;
	
	@Autowired
	CommentsRepository cr;
	
	@RequestMapping(value = "/cargaPosts", method = RequestMethod.GET)
	public ModelAndView getAllPostJSON( Model model, HttpServletRequest request) {
		//Ruta de apiRest Posts
		final String uri = "https://jsonplaceholder.typicode.com/posts";
		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Posts>> postResponse = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Posts>>() {
				});
		
		//Obtengo lista de post 
		List<Posts> lista = postResponse.getBody();
		model.addAttribute("posts", lista);
		System.out.println("Cantidad: " + lista.size());
		
		//guardar en bbdd
		List<Posts> ps = new ArrayList<>();
		
		for (Posts posts : lista) {
			int userId = posts.getUserId();
			Optional<Users> user = ur.findById(userId);
			posts.setUser(user.get());
			ps.add(posts);
		}
		
		pr.saveAll(ps);
		System.out.println("carga de posts exitosa");

		return new ModelAndView("redirect:/listarPosts", "model", model);
	}
	
	//Metodo listar todos los post 
	@RequestMapping(value = "/listarPosts", method = RequestMethod.GET)
	public ModelAndView listarPosts() {
		List<Posts> lista = pr.findAll();
	// System.out.println(lista.get(0).getAlumnos().toString());
		return new ModelAndView("home", "lista", lista);
	}
	
	//Metodo Borrar por lote todos los comentarios y posteo  
	@RequestMapping(value = "/borrar")
	public ModelAndView borrar() {
			cr.deleteAllInBatch();
			pr.deleteAllInBatch();
			System.out.println("borrado exitoso");
		return new ModelAndView("redirect:/");

	}
		
}
