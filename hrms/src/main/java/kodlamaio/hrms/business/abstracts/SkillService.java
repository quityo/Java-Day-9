package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDto;

public interface SkillService {
	DataResult<SkillDto> add(SkillDto skillDto);
		
	DataResult<List<Skill>> getAll();
	
	}