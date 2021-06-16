package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobseekerService {

	DataResult<List<Jobseeker>> getAllSorted();
	Result add(Jobseeker jobseeker);
	Result update(Jobseeker jobseeker);
	Result delete(int id);
	DataResult<Jobseeker> getById(int id);
	
	DataResult<List<Jobseeker>> getAll();
	
	DataResult<Jobseeker> getByNationalId(String nationalId);
}