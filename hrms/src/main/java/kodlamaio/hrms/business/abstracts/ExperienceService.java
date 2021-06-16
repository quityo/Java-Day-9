package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;

public interface ExperienceService {

	 DataResult<List<Experience>> getAll();
	    DataResult<ExperienceDto> add(ExperienceDto ExperienceDto);
	    DataResult<List<ExperienceDto>> findAllByCvIdOrderByEndAt(int id);
}