package kodlamaio.hrms.core.utilities.helpers.abstracts;

public interface ValidationService {
	boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);
}