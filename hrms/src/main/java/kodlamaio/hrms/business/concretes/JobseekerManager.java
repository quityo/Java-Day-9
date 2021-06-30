package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;
	private LanguageService languageService;
	private SkillService skillService;
	private EducationService educationService;
	private ExperienceService experienceService;
	
	
	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao, 
			LanguageService languageService,
			SkillService skillService,
			EducationService educationService,
			ExperienceService experienceService
			
		
			) {
		super();
		this.jobseekerDao = jobseekerDao;
		this.languageService = languageService;
		this.skillService = skillService;
		this.educationService = educationService;
		this.experienceService = experienceService;
	}

	@Override
	public Result add(Jobseeker jobseeker) {
		var result = this.jobseekerDao.save(jobseeker);
		if (result != null) {
			return new SuccessResult("Jobseeker Add OK");
		}
		return new ErrorResult("Jobseeker Add NOT OK");
	}
	
	@Override
	public Result update(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been updated.");
	}

	@Override
	public Result delete(int userId) {
		this.jobseekerDao.deleteById(userId);
		return new SuccessResult("Jobseeker has been deleted.");
	}
	
	@Override
	public DataResult<Jobseeker> getByUserId(int userId) {
		var result = this.jobseekerDao.getByUserId(userId);
		if (result != null) {
			return new SuccessDataResult<Jobseeker>("User founded");
		}
		return new ErrorDataResult<Jobseeker>("User NOT founded");
	}
	
	@Override
	public DataResult<List<Jobseeker>> getAll() {
		var result = this.jobseekerDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Jobseeker>>(result,"Jobseekers listed");	
		}
		return new ErrorDataResult<List<Jobseeker>>("Jobseekers NOT listed");	
	}

	@Override
	public DataResult<Jobseeker> getByNationalId(String nationalId) {
		var result = this.jobseekerDao.getByNationalId(nationalId);
		if (result != null) {
			return new SuccessDataResult<Jobseeker>("User founded");
		}
		return new ErrorDataResult<Jobseeker>("User NOT founded");
	}

	
	

	
	@Override
	public DataResult<CvDto> getJobseekerCvByUserId(int userId) {
		CvDto cv = new CvDto();
		cv.setExperiences(this.experienceService.getByJobseekerIdOrderByDateOfEndASC(userId).getData());
		cv.setLanguages(this.languageService.getAll().getData());
		cv.setSkills(this.skillService.getAll().getData());
		cv.setEducations(this.educationService.getByJobseekerIdOrderByEndYearOfSchoolASC(userId).getData());
		return new SuccessDataResult<CvDto>(cv);
	}

}