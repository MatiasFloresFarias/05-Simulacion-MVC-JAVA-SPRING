package cl.awake.simulacro.modelos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "posts")
public class Posts {
	@Id
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private int id;
	
	private String title;
	
	private String body;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private Users user;

	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	@JsonIgnore
	//@Transient
	private Set<Comments> comments;

	@Column(name = "userId", insertable = false, nullable = false, updatable = false)
	private int userId;

	public Posts() {
		super();
	}

	public Posts(int id, String title, String body, Users user, Set<Comments> comments) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.user = user;
		this.comments = comments;
	}

	public Posts(int id, String title, String body, Users user, Set<Comments> comments, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.user = user;
		this.comments = comments;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//Cantidad de comentarios 
	public int getCantidadComments() {
		int cantidad = comments.size();
		return cantidad;
	}

}
