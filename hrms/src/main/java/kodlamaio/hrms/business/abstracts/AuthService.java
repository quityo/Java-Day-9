package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerRegisterDto;

public interface AuthService {

	Result employerRegister(EmployerRegisterDto employer);
	
    Result jobSeekerRegister(JobSeekerRegisterDto jobSeeker);
}