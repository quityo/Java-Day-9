package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;
	
	@Column(name = "name")
	@NotBlank
    private String name;
	
	@Column(name = "department")
	@NotBlank
	private String department;
	
	@Column(name = "start_at")
	private Date startAt;
	
	@Column(name = "end_at")
	private Date endAt;

	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	 @ManyToOne(targetEntity = Cv.class)
	 @JoinColumn(name = "cv_id")
	 private Cv cv;
	 
	 @ManyToOne(targetEntity = Graduate.class)
	    @JoinColumn(name = "graduate_id", referencedColumnName = "id", nullable = false)
	    private Graduate graduate;
	 
	 @Column(name = "created_date", columnDefinition = "Date default CURRENT_DATE")
	    private final LocalDateTime createdDate = LocalDateTime.now();
	
}