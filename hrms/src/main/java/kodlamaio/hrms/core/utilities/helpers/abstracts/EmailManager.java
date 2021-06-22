package kodlamaio.hrms.core.utilities.helpers.abstracts;

import org.springframework.stereotype.Service;

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