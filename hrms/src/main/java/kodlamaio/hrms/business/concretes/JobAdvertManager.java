package kodlamaio.hrms.business.concretes;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;


@Service
public class JobAdvertManager implements JobAdvertService {
	private JobAdvertDao jobAdvertDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	private WorkTypeDao workTypeDao;
	private WorkTimeDao workTimeDao;
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, JobPositionDao jobPositionDao, EmployerDao employerDao,
			CityDao cityDao, WorkTypeDao workTypeDao, WorkTimeDao workTimeDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
		this.workTypeDao = workTypeDao;
		this.workTimeDao = workTimeDao;
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "İş ilanları listelendi");
	}

	@Override
	public Result add(JobAdvertDto jobAdvertDto) {
		JobAdvert jobAdvert = new JobAdvert();
		jobAdvert.setJobAdvertId(0);
		jobAdvert.setDescription(jobAdvertDto.getDescription());
		jobAdvert.setSalaryMin(jobAdvertDto.getSalaryMin());
		jobAdvert.setSalaryMax(jobAdvertDto.getSalaryMax());
		jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
		jobAdvert.setReleaseDate(LocalDate.now());
		jobAdvert.setDeadline(jobAdvertDto.getDeadline());
		jobAdvert.setActive(true);
		jobAdvert.setConfirm(false);
		
		jobAdvert.setEmployer(this.employerDao.getByUserId(jobAdvertDto.getEmployerId()));

		jobAdvert.setJobPosition(this.jobPositionDao.getByJobPositionId(jobAdvertDto.getJobPositionId()));
		jobAdvert.setCity(this.cityDao.getByCityId(jobAdvertDto.getCityId()));
		jobAdvert.setWorkType(this.workTypeDao.getByWorkTypeId(jobAdvertDto.getWorkTypeId()));
		jobAdvert.setWorkTime(this.workTimeDao.getByWorkTimeId(jobAdvertDto.getWorkTimeId()));
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvert>> sortByReleaseDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "releaseDate");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),
				"Yayın tarihine göre artan olarak listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_CompanyName(companyName),
				"Şirket adına göre iş ilanları listelendi");
	}

	@Override
	public Result updateIsActive(boolean isActive,  int jobAdvertId) {
		this.jobAdvertDao.updateIsActive(isActive, jobAdvertId);
		return new SuccessResult("İş ilanı aktiflik durumu güncellendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsConfirm(boolean isConfirm) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsConfirm(isConfirm));
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive) {
		return new SuccessDataResult<List<JobAdvert>>(
				this.jobAdvertDao.getByIsConfirmAndIsActive(isConfirm, isActive));
	}

	@Override
	public Result updateIsConfirm(boolean isConfirm, int jobAdvertId) {
		this.jobAdvertDao.updateIsConfirm(isConfirm, jobAdvertId);
		return new SuccessResult("İş ilanı onaylandı");
	}

	@Override
	public DataResult<JobAdvert> getById(int jobAdvertId) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(jobAdvertId));
	}


}