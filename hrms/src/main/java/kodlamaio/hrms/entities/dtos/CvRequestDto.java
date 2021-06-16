package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvRequestDto {

    private int id;
    private int candidateId;
    private String linkedinAddress;
    private String githubAddress;
    private String image;
    private String description;
}