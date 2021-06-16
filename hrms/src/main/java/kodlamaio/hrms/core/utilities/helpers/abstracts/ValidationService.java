package kodlamaio.hrms.core.utilities.helpers.abstracts;

import java.sql.Date;

public interface ValidationService {
	boolean validateByMernis(long nationalId, String firstName, String lastName, Date yearOfBirth);
}