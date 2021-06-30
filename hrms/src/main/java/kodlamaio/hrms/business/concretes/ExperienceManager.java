package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

    @Autowired
    public  ExperienceManager( ExperienceDao experienceDao) {
    	super();
        this.experienceDao = experienceDao;
    }

    @Override
	public Result add(Experience experience) {
		var result = this.experienceDao.save(experience);
		
		if (result != null) {
			return new SuccessResult("Experience add ok");
		}
		return new ErrorResult("Experience add NOT ok");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		var result = this.experienceDao.findAll();
		
		if (result != null) {
			return new SuccessDataResult<List<Experience>>(result);
		}
		return new ErrorDataResult<List<Experience>>("Experiences getAll NOT ok");
	}

	@Override
	public DataResult<List<Experience>> getByJobseekerIdOrderByDateOfEndASC(int jobseekerId) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"endYearOfWork");
		
		var result = this.experienceDao.findAll(sortBy);
		if ( result != null) {
			return new SuccessDataResult<List<Experience>>(result,"asc sorted ok");
		}
		return new ErrorDataResult<List<Experience>>("asc sorted NOT ok");
	}

	@Override
	public DataResult<List<Experience>> getByJobseekerIdOrderByDateOfEndDESC(int jobseekerId) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"endYearOfWork");
		
		var result = this.experienceDao.findAll(sortBy);
		if(result != null){
			return new SuccessDataResult<List<Experience>>(result,"desc sorted ok");
			}
		return new ErrorDataResult<List<Experience>>("desc sorted NOT ok");
	}
	
	
}