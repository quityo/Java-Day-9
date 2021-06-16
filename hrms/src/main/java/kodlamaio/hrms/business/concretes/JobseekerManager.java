package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobseekerService {

	@Autowired
	private JobseekerDao jobseekerDao;
	
	
	public JobseekerManager(JobseekerDao jobseekerDao)
	{
		super();
		this.jobseekerDao = jobseekerDao;
	}


	@Override
	public Result add(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been added.");
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
	public DataResult<List<Jobseeker>> getAllSorted(){
		Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
		return new SuccessDataResult<List<Jobseeker>>
		(this.jobseekerDao.findAll(sort),"Başarılı");
	}
}