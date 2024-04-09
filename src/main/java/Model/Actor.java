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
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(name = "name", columnDefinition = "NVARCHAR(100)")
    private String name;
    
    @JsonIgnoreProperties("actors")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "movie_actor",
        joinColumns = @JoinColumn(name = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies;


    private String srcImg;
    
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String des;
    public String getDes() {
		return des;
	}
    
    public void setDes(String des) {
		this.des = des;
	}
    
    public String getSrcImg() {
		return srcImg;
	}
    @Column(name = "nationality", columnDefinition = "NVARCHAR(100)")
    private String nationality;
    
    private boolean sex; // True là nam, false là nữ
    
    
    private Date birth;

    public Actor() {
		// TODO Auto-generated constructor stub
	}
	

	public Actor(String name, Set<Movie> movies, String nationality, boolean sex, Date birth) {
		super();
		this.name = name;
		this.movies = movies;
		this.nationality = nationality;
		this.sex = sex;
		this.birth = birth;
	}



	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	public void setSrcImg(String srcImg) {
		this.srcImg = srcImg;
	}
	

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", movies=" + movies + "]";
	}
    
    // Getters and setters
    
}

