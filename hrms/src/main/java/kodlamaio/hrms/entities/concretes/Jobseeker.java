package kodlamaio.hrms.entities.concretes;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "job_seekers")

public class Jobseeker extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id",nullable = false)
	private int id;
	
	@NotBlank
	@Column(name= "first_name")
	private String firstName;
	
	@NotBlank
	@Column(name= "last_name")
	private String lastName;
	
	@NotBlank
	@Column(name= "national_id")
	private String nationalId;
	
	@Column(name= "date_of_birth")
	private Date dateOfBirth;
}