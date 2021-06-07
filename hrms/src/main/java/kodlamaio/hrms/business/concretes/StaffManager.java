package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class StaffManager implements StaffService{

	@Override
	public Result confirm() {
		return new SuccessResult("Staff Confirm OK");
	}

}