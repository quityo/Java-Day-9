package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cv ")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})

public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "jobseeker_id", referencedColumnName = "user_id")
	@ManyToOne()
	private Jobseeker jobseeker;

	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@Column(name = "cover_letter")
	private String coverLetter;

	@OneToMany(mappedBy = "cv")
	private List<Education> educations;

	@OneToMany(mappedBy = "cv")
	private List<Experience> experiences;

	@OneToMany(mappedBy = "cv")
	private List<Language> languages;

	@OneToMany(mappedBy = "cv")
	private List<Skill> skills;

}