package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@NoArgsConstructor

@EqualsAndHashCode(callSuper = false)
@Table(name = "job_seekers")

public class JobSeeker extends User{
	
	@Column(name="first_name",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String lastName;
	
	@Column(name="nationality_id",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String nationalityId;
	
	@Column(name="year_of_birth",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private int yearOfBirth;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Education> educations;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Language> languages;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Link> links;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Skill> skills;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Explanation> explanations;
	
	
	public JobSeeker(String email, String password, boolean status, String firstName, String lastName, String nationalityId, int yearOfBirth) {
		super(email, password, status);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.yearOfBirth = yearOfBirth;
	}
	

}
