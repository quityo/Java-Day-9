package kodlamaio.hrms.core.utilities.helpers.abstracts;

public interface VerificationService {
	void sendLink(String email);
	String sendCode();
}