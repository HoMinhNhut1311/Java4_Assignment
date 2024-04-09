package Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "title", columnDefinition = "NVARCHAR(200)")
    private String title;
    
    @JsonIgnoreProperties("movies")
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    
    @Column(name = "director", columnDefinition = "NVARCHAR(100)")
    private String director;
    
    @Column(name = "des", columnDefinition = "nvarchar(max)")
    private String des;
    
    @Column(columnDefinition = "text")
    private String srcImg;
    
    private int visit;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "movie_actor",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    
    public String getSrcImg() {
		return srcImg;
	}
    public void setSrcImg(String srcImg) {
		this.srcImg = srcImg;
	}
    private int duration;
    
    @Column(name = "release")
    private Date releaseYear;
    
    private double rating;
    
    @Column(name = "sourceTrailer", columnDefinition = "varchar(300)")
    private String sourceTrailer;
    
    public String getDes() {
		return des;
	}
    public void setDes(String des) {
		this.des = des;
	}
    public Movie() {
		// TODO Auto-generated constructor stub
	}
    
   public Movie(String title, Genre genre, String director, String des, String srcImg, List<Actor> actors,
			int duration, Date releaseYear, double rating, String sourceTrailer, String sourceWatch) {
		this.id = 0;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.des = des;
		this.srcImg = srcImg;
		this.actors = actors;
		this.duration = duration;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.sourceTrailer = sourceTrailer;
		this.sourceWatch = sourceWatch;
	}
public void setSourceTrailer(String sourceTrailer) {
	this.sourceTrailer = sourceTrailer;
}
   public String getSourceTrailer() {
	return sourceTrailer;
}
   
   @Column(name = "sourceWatch", columnDefinition = "varchar(300)")
   private String sourceWatch;
    

	public String getSourceWatch() {
		return sourceWatch;
	}
	public void setSourceWatch(String sourceWatch) {
		this.sourceWatch = sourceWatch;
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
	
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public Date getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", director=" + director + ", des=" + des + ", duration=" + duration + ", releaseYear=" + releaseYear + ", rating="
				+ rating + ", source=" + sourceTrailer + "]";
	}
	
	

	
    
    // Getters and setters
}
