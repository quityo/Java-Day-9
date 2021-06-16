package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
    @Autowired
    private EmployerDao employerDao;
    
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }
	@Override
	public Result add(Employer employer) {
		var result = this.employerDao.save(employer);
		if (result != null) {
			return new SuccessResult("Employer Add OK");
		}
		return new ErrorResult("Employer Add NOT OK");
	}
//
//	@Override
//	public void update(Employer employer) {
//		this.employerDao.save(employer);
//      return new SuccessResult("Employer has been updated.");
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.employerDao.deleteById(id);
//	    return new SuccessResult("Employer has been deleted.");
//	}
//
	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	
	
}