package tp.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name="User")
@Getter @Setter @NoArgsConstructor
public class User {

	@Id //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_incr coté base
	private Integer id;
	
	@Column(name="nom")
	private String login;
	
	//@Column(name="password") par défaut
	private String password;


	public User(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	
}
