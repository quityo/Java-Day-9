package kodlamaio.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	@JsonIgnore()
	public Jobseeker jobseeker;
	public List<Education> educations;
	public List<Experience> experiences;
	public List<Language> languages;
	public List<Skill> skills;
	}
