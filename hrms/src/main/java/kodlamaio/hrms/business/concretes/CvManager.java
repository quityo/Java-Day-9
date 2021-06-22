package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;

	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<List<Cv>> getByJobseekerId(int jobseekerId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByJobseeker_UserId(jobseekerId),
				"İş arayana ait CV listelendi");
		}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "CV'ler listelendi");
	}

//	@Override
//	public DataResult<List<CurriculumVitaeDto>> getCurriculumVitaeDetails() {
//		return new SuccessDataResult<List<CurriculumVitaeDto>>(this.curriculumVitaeDao.getCurriculumVitaeDetails());
//	}

}