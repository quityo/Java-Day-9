package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	Result add(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAllSorted();
	DataResult<List<JobPosition>> getAll();
	DataResult<JobPosition> getJobByTitle(String title);
	DataResult<Optional<JobPosition>> getById(int id);
}