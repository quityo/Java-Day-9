package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		var result = this.educationDao.save(education);
		if (result != null) {
			return new SuccessResult(Messages.educationAdded);
		}
		return new ErrorResult(Messages.educationNotAdded);
	}

	@Override
	public DataResult<List<Education>> getAll() {
		var result = this.educationDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Education>>(result);
		}
		return new ErrorDataResult<List<Education>>();
	}

	@Override
	public DataResult<List<Education>> getByJobSeekerIdOrderByGraduationDateASC(int jobSeekerId) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"graduationDate");
		var result = this.educationDao.getByJobSeekerId(sortBy,jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Education>>(result,"ASC sorted.");
		}
		return new SuccessDataResult<List<Education>>("Something is wrong. ASC NOT sorted");
	}

	@Override
	public DataResult<List<Education>> getByJobSeekerIdOrderByGraduationDateDESC(int jobSeekerId) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"graduationDate");
		var result = this.educationDao.getByJobSeekerId(sortBy,jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Education>>(result,"DESC sorted.");
		}
		return new SuccessDataResult<List<Education>>("Something is wrong. DESC NOT sorted.");
	}

}
