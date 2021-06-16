package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {

	@JsonIgnore
    private int id;
    private int cvId;
    private String companyName;
    private LocalDate startAt;
    private LocalDate endAt;
    private int jobPositionId;
    }

