package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.service.FakeMernisService;

public class IdentityValidation {
	public static boolean isRealPerson(String tcNo) {
		return FakeMernisService.validate(tcNo);
	}
}