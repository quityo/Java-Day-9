package kodlamaio.hrms.entities.concretes;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@Table(name = "job_adverts")
@AllArgsConstructor
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
	
	@NotNull
	@Column(name = "description",nullable = false)
	private String description;
	
    
    @PositiveOrZero
	@Column(name = "salary_min")
	private int salaryMin;
	
    
    @PositiveOrZero
	@Column(name = "salary_max")
	private int salaryMax;
	    
    @Positive
	@Column(name = "open_position_count")
	private int openPositionCount;
	
    @Column(name = "end_date")
    private java.sql.Date endDate;
	
    
	
	@Column(name = "is_active")
    private boolean active;

	@Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
		
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
    @JoinColumn(name = "work_type_id")
    private WorkType workType;
	
	@ManyToOne()
    @JoinColumn(name = "work_time_id")
    private WorkTime workTime;
	
}