package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface JobseekerService {
	
	Result add(Jobseeker jobSeeker);
	Result update(Jobseeker jobseeker);
	Result delete(int userId);
	
	DataResult<Jobseeker> getByUserId(int userId);
	DataResult<List<Jobseeker>> getAll();
	DataResult<Jobseeker> getByNationalId(String nationalId);

	DataResult<CvDto> getJobseekerCvByUserId(int userId);
}