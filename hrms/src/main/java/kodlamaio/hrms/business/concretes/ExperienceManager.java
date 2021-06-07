package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.constants.Messages;
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
	public  ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		var result = this.experienceDao.save(experience);
		
		if (result != null) {
			return new SuccessResult(Messages.experienceAdded);
		}
		return new ErrorResult(Messages.experienceNotAdded);
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		var result = this.experienceDao.findAll();
		
		if (result != null) {
			return new SuccessDataResult<List<Experience>>(result);
		}
		return new ErrorDataResult<List<Experience>>("Something is wrong");
	}

	@Override
	public DataResult<List<Experience>> getByJobSeekerIdOrderByDateOfEndASC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"dateOfEnd");
		
		var result = this.experienceDao.getByJobSeekerId(sortBy,jobSeeker_id);
		if ( result != null) {
			return new SuccessDataResult<List<Experience>>(result,"ASC sorted.");
		}
		return new ErrorDataResult<List<Experience>>("Something is wrong. ASC NOT sorted");
	}

	@Override
	public DataResult<List<Experience>> getByJobSeekerIdOrderByDateOfEndDESC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"dateOfEnd");
		
		var result = this.experienceDao.getByJobSeekerId(sortBy,jobSeeker_id);
		if(result != null){
			return new SuccessDataResult<List<Experience>>(result,"DESC sorted.");
			}
		return new ErrorDataResult<List<Experience>>("Something is wrong. DESC NOT sorted.");
	}
	
	
}