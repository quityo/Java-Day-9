package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}



	@Override
	public Result add(Employer employer) {
		var result = this.employerDao.save(employer);
		if (result != null) {
			return new SuccessResult(Messages.employerAdded);
		}
		return new ErrorResult(Messages.employerNotAdded);
	}
	
	@Override
	public Result delete(final Employer employer) {
		employerDao.delete(employer);

		return new SuccessResult(Messages.employerDeleted);
	}

	@Override
	public Result update(final Employer employer) {
		employerDao.save(employer);

		return new SuccessResult(Messages.employerUpdated);
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		var result = this.employerDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Employer>>(result,"Employers listed");	
		}
		return new ErrorDataResult<List<Employer>>("Employers listed");	
	}


	@Override
	public DataResult<Employer> getById(final int id) {
		final Optional<Employer> employer = employerDao.findById(id);

		if (employer.isEmpty())
			return new ErrorDataResult<Employer>(Messages.employerNotFound);

		return new SuccessDataResult<Employer>(employer.get());
	}

	
}