package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column(name="user_name",nullable=false)
	private String userName;
	private String password;
	private String email;
	private String about;
}
