package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExplanationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExplanationDao;
import kodlamaio.hrms.entities.concretes.Explanation;

@Service
public class ExplanationManager implements ExplanationService{
	
	private ExplanationDao explanationDao;

	@Autowired
	public ExplanationManager(ExplanationDao explanationDao) {
		super();
		this.explanationDao = explanationDao;
	}
	
	@Override
	public Result add(Explanation explanationDao) {
		var result = this.explanationDao.save(explanationDao);
		if (result != null) {
			return new SuccessResult(Messages.explanationAdded);
		}
		return new ErrorResult(Messages.explanationNotAdded);
	}

	@Override
	public DataResult<List<Explanation>> getAll() {
		var result =this.explanationDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Explanation>>(result);
		}
		return new ErrorDataResult<List<Explanation>>("Something is wrong.");
	}

	@Override
	public DataResult<List<Explanation>> getByJobSeekerId(int jobSeekerId) {
		var result = this.explanationDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Explanation>>(result);
		}
		return new ErrorDataResult<List<Explanation>>("Something is wrong.");
	}
}