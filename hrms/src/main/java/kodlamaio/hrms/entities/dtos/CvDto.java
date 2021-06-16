package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
import java.util.List;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
    private int id;
    private int jobseekerId;
    private String githubAddress;
    private String linkedinAddress;
    private String description;
    private String image;
    private Date updatedDate;
    private List<Language> languages;
    private List<Skill> skills;
    private List<Education> educations;
    private List<Experience> experiences;
}