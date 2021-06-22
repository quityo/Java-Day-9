package kodlamaio.hrms.core.utilities.helpers.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class MernisServiceAdapter implements CheckUserService {

	@Override
	public boolean checkIfRealPerson(Jobseeker jobseeker) {
		// simulation
		if (jobseeker.getNationalId() == jobseeker.getNationalId()
				&& jobseeker.getFirstName() == jobseeker.getFirstName()
				&& jobseeker.getLastName() == jobseeker.getFirstName()
				&& jobseeker.getDateOfBirth() == jobseeker.getDateOfBirth()) {
			return true;
		}
		return false;
	}

}