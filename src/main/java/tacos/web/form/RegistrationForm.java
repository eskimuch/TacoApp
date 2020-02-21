package tacos.web.form;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import tacos.persistence.entity.UserEntity;

@Data
public class RegistrationForm {

	private String username;

	private String password;

	private String fullname;

	private String street;

	private String city;

	private String state;

	private String zip;

	private String phoneNumber;

	public UserEntity toUser(PasswordEncoder passwordEncoder) {
		return new UserEntity(username, passwordEncoder.encode(password), fullname, street, city, state, zip,
				phoneNumber);
	}

}
