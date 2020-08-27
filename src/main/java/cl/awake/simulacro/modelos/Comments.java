package cl.awake.simulacro.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comments")
public class Comments {
	@Id
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private int id;
	
	private String name;
	
	private String email;
	
	private String body;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postId")
    @JsonIgnore
	private Posts post;
    
    @Column(name = "postId", insertable = false, nullable = false, updatable = false)
	private int postId;
    
    
	public Comments() {
		super();
	}

	public Comments(int id, String name, String email, String body, Posts post) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
		this.post = post;
	}
	
	public Comments(int id, String name, String email, String body, Posts post, int postId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
		this.post = post;
		this.postId = postId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
    
    
	
}
