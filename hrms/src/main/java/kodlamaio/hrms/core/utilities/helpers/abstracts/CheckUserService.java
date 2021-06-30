package kodlamaio.hrms.core.utilities.helpers.abstracts;

public interface CheckUserService {
	
	boolean checkIfRealPerson(String nationalityId, int dateOfBirth);
		
}