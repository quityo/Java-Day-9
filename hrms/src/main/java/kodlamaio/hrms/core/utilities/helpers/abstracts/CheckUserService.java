package kodlamaio.hrms.core.utilities.helpers.abstracts;

import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface CheckUserService {
	
	boolean checkIfRealPerson(Jobseeker jobseeker);
}