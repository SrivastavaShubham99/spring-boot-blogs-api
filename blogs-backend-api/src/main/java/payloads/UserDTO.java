package payloads;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor

public class UserDTO {
	
	private String userName;
	private int id;
	private String password;
	private String email;
	private String about;
}
