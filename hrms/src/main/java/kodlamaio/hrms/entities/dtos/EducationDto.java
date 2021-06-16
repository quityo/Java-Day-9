package kodlamaio.hrms.entities.dtos;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	
    private int educationId;
    private int cvId;
    private String name;
    private int graduateId;
    private String department;
    private LocalDate startAt;
    private LocalDate endAt;
}