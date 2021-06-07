package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Explanation;

public interface ExplanationService {

	Result add(Explanation explanation);
	DataResult<List<Explanation>> getAll();
	DataResult<List<Explanation>> getByJobSeekerId(int jobSeekerId);
}
