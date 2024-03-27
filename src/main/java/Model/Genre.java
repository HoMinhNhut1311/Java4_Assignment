package Model;

import javax.persistence.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genre_id;
    
    @Column(name = "name", columnDefinition = "NVARCHAR(100)")
    private String name;
    
    public Genre() {
		// TODO Auto-generated constructor stub
	}
    

	public Genre(Long genre_id, String name) {
		super();
		this.genre_id = genre_id;
		this.name = name;
	}


	public Long getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(Long genre_id) {
		this.genre_id = genre_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", name=" + name + "]";
	}
    
    // Getters and setters
}
