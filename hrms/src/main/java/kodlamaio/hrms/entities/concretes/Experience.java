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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class Experience{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int experienceId;

	@NotBlank
	@Column(name = "working_place")
	private String workingPlace;
	
	@NotBlank
	@Column(name = "start_year_of_work")
	private LocalDate startYearOfWork;
	
	@NotBlank
	@Column(name = "end_year_of_work")
	private LocalDate endYearOfWork;
	
	@ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
	
}