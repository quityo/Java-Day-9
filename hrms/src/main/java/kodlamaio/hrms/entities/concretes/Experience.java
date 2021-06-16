package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column(name = "id")
    private int id;

	@NotBlank
	@Column(name = "working_place")
	private String workingPlace;
	
	@NotBlank
	@Column(name = "start_at")
	private LocalDate startAt;
	
	@NotBlank
	@Column(name = "end_at", nullable = true)
	private LocalDate endAt;
	
	@ManyToOne(targetEntity = JobPosition.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "job_position_id", referencedColumnName = "id", nullable = false)
	@NotBlank
	private  JobPosition jobPosition;
	
	@ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name = "cv_id")
    private Cv cv;
	
}