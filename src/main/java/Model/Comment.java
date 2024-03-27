package Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Users user;
    
    @ManyToOne
    private Movie movie;
    
    @Column(name = "content", columnDefinition = "NVARCHAR(100)")
    private String content;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    
    public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", movie=" + movie + ", content=" + content + ", createdAt="
				+ createdAt + "]";
	}
    
    // Getters and setters
    
}


