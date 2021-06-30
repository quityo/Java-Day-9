package kodlamaio.hrms.core.utilities.helpers.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public boolean isVerified(Boolean isVerifyEmail) {
		if (isVerifyEmail) {
			return true;
		}
		return false;
	}

}