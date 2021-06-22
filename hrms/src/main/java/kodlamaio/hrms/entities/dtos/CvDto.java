package kodlamaio.hrms.entities.dtos;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	private int cvId;
	private String schoolName;
	private String department;
	private LocalDate startYearOfSchool;
	private LocalDate endYearOfSchool;
	private String workingPlace;
	private LocalDate startYearOfWork;
	private LocalDate endYearOfWork;
	private String language;
	private int level;
	private String githubAddress;
	private String linkedinAddress;
	private String skillName;
	private String coverLetter;
	}
