package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
		if (education.getEndYearOfSchool() == null) {
			education.setEndYearOfSchool(LocalDate.parse("Devam ediyor"));
		}
		this.educationDao.save(education);
		return new SuccessResult("Eğitim durumu eklendi");
	}

	@Override
	public DataResult<List<Education>> getByJobseekerIdOrderByEndYearOfSchoolASC(int jobseekerId) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"endYearOfSchool");
		var result = this.educationDao.findAll(sortBy);
		if (result != null) {
			return new SuccessDataResult<List<Education>>(result,"asc sorted ok");
		}
		return new SuccessDataResult<List<Education>>("asc sorted NOT ok");
	}

	@Override
	public DataResult<List<Education>> getByJobseekerIdOrderByEndYearOfSchoolDESC(int jobseekerId) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"endYearOfSchool");
		var result = this.educationDao.findAll(sortBy);
		if (result != null) {
			return new SuccessDataResult<List<Education>>(result,"desc sorted ok");
		}
		return new SuccessDataResult<List<Education>>("desc sorted NOT ok");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Eğitim durumları listelendi");
	}

}