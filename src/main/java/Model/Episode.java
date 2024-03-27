package Model;

import javax.persistence.*;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Movie movie;
    
    @Column(name = "episode_number")
    private int episodeNumber;
    
    @Column(name = "title", columnDefinition = "NVARCHAR(100)")
    private String title;
    
    @Column(name = "description", columnDefinition = "NVARCHAR(200)")
    private String description;
    
    public Episode() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Episode [id=" + id + ", movie=" + movie + ", episodeNumber=" + episodeNumber + ", title=" + title
				+ ", description=" + description + "]";
	}
    
    
    // Getters and setters
}
