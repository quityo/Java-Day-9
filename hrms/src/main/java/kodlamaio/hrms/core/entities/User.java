package kodlamaio.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Email(message = "Email formatı geçersiz")
	@NotBlank(message = "Email boş olamaz")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Şifre boş olamaz")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "Şifre tekrarı boş olamaz")
	@Column(name = "password_again")
	private String password_again;

	@Column(name = "is_verify_email")
	private boolean isVerifyEmail;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
}