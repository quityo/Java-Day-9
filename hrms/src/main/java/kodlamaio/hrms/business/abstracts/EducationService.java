package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.EducationDto;

public interface EducationService {
	DataResult<List<EducationDto>> getAll();
    DataResult<EducationDto> add(EducationDto education);
    DataResult<List<EducationDto>> findAllByCvIdOrderByEndAtDesc(int cvId);
	}
