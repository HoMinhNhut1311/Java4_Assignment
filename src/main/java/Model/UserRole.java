package Model;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    private String roleName;

	public Long getId() {
		return role_id;
	}

	public void setId(Long id) {
		this.role_id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + role_id + ", roleName=" + roleName + "]";
	}

    // Getters and setters
    
}
	
