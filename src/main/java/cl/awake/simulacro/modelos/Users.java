package cl.awake.simulacro.modelos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private int id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@JsonIgnore
	@Transient
	private Set<Posts> posts;

	public Users() {
		super();
	}

	public Users(int id, String name, String username, String email, Set<Posts> posts) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Posts> getPosts() {
		return posts;
	}

	public void setPosts(Set<Posts> posts) {
		this.posts = posts;
	}
	
	
}
