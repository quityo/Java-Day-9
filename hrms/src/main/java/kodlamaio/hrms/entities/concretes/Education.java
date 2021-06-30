package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class Education{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int educationId;
	
	@Column(name = "school_name")
	@NotBlank
    private String schoolName;
	
	@Column(name = "department")
	@NotBlank
	private String department;
	
	@Column(name = "start_year_of_school")
	private LocalDate startYearOfSchool;
	
	@Column(name = "end_year_of_school")
	private LocalDate endYearOfSchool;

	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	 @ManyToOne()
	 @JoinColumn(name = "jobseeker_id", referencedColumnName = "user_id")
	 private Jobseeker jobseeker;
}