package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobseekerForRegisterDto {

	private String firstName;
	private String lastName;
	private String nationalId;
	private LocalDate dateOfBirth;
	
	private String email;
	private String password;
	
	private String passwordAgain;

}