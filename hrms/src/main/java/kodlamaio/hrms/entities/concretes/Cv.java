package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cvs")
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name="image_link")
	private String imageLink;
	
	
	@OneToMany(mappedBy = "cv")
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "cv")
	private List<Education> educations;

	@OneToMany(mappedBy = "cv")
	private List<Experience> experiences;

	@OneToMany(mappedBy = "cv")
	private List<Language> languages;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jobseeker_id", referencedColumnName = "user_id")
	private Jobseeker jobseeker;
	
}