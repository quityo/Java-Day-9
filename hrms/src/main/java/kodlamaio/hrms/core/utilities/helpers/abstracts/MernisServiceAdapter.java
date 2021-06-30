package kodlamaio.hrms.core.utilities.helpers.abstracts;

import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements CheckUserService {

	@Override
	public boolean checkIfRealPerson(String nationalityId, int dateOfBirth) {
		if (nationalityId.length() == 11 && dateOfBirth > 1900) {
			return true;
		}
		else {
			return false;
		}
	}

}