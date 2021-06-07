package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService extends BaseService<JobSeeker> {
	
	DataResult<JobSeeker> getByNationalityId(String nationalityId);
	
}