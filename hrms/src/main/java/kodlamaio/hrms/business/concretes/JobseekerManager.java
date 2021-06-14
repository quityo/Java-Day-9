package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LetterService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dtos.JobSeekerCVDto;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;
	private ExperienceService experienceService;
	private LanguageService languageService;
	private ImageService imageService;
	private LinkService linkService;
	private SkillService skillService;
	private EducationService educationService;
	private LetterService letterService;

	
	public JobseekerManager(JobseekerDao jobseekerDao, 
			ExperienceService experienceService,
			LanguageService languageService, 
			ImageService imageService,
			LinkService linkService, 
			SkillService skillService,
			EducationService educationService,
			LetterService  letterService)
	{
		super();
		this.jobseekerDao = jobseekerDao;
		this.experienceService = experienceService;
		this.languageService = languageService;
		this.imageService = imageService;
		this.linkService = linkService;
		this.skillService = skillService;
		this.educationService = educationService;
		this.letterService = letterService;
	}


	@Override
	public Result add(Jobseeker jobseeker) {
		var result = this.jobseekerDao.save(jobseeker);
		if (result != null) {
			return new SuccessResult("Job Seeker Add OK");
		}
		return new ErrorResult("Job Seeker Add NOT OK");
	}
	@Override
	public Result update(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobseekerDao.deleteById(id);
		return new SuccessResult("Jobseeker has been deleted.");
	}

	@Override
	public DataResult<Jobseeker> getById(int id) {
		var result = this.jobseekerDao.getById(id);
		if (result != null) {
			return new SuccessDataResult<Jobseeker>("User founded");
		}
		return new ErrorDataResult<Jobseeker>("User NOT founded");
	}
	@Override
	public DataResult<List<Jobseeker>> getAll() {
		final List<Jobseeker> jobseekers = jobseekerDao.findAll();

		return new SuccessDataResult<List<Jobseeker>>(jobseekers);	
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
	public DataResult<JobSeekerCVDto> getJobseekerCVById(int id) {
		
		JobSeekerCVDto cv = new JobSeekerCVDto();
		cv.setJobseeker(this.getById(id).getData());
		cv.setImages(this.imageService.getByUserId(id).getData());
		cv.setEducations(this.educationService.getAllByJobseekerIdOrderByEndAtDesc(id).getData());
		cv.setLanguages(this.languageService.getByJobseekerId(id).getData());
		cv.setLinks(this.linkService.getByJobseekerId(id).getData());
		cv.setSkills(this.skillService.getByJobseekerId(id).getData());
		cv.setExperiences(this.experienceService.getAllByJobseekerIdOrderByEndAtDesc(id).getData());
		cv.setLetters(this.letterService.getByJobseekerId(id).getData());
		return new SuccessDataResult<JobSeekerCVDto>(cv);
	}

	@Override
	public DataResult<List<Jobseeker>> getAllSorted(){
		Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
		return new SuccessDataResult<List<Jobseeker>>
		(this.jobseekerDao.findAll(sort),"Başarılı");
	}
}