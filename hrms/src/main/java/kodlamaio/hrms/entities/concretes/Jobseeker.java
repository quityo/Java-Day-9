package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@PrimaryKeyJoinColumn(name = "user_id")
public class Jobseeker extends User{

	
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
	private LocalDate dateOfBirth;
	
	@OneToOne(mappedBy = "jobseeker")
	@JsonIgnore()
	private Cv cv;

	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Education> educations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Skill> skills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Experience> experiences;
	
}	
