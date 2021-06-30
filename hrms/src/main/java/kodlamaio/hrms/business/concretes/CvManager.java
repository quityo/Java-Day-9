package kodlamaio.hrms.business.concretes;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public CvManager(CvDao cvDao, 
			CloudinaryService cloudinaryService) {
		this.cvDao = cvDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Cv cv) {
		var result = this.cvDao.save(cv);
		if (result != null) {
			return new SuccessResult("cv added ok");
		}
		return new ErrorResult("cv added NOT ok");
	}
	

	@Override
	public DataResult<List<Cv>> getAll() {
		var result = this.cvDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Cv>>(result,"OK");
		}
		return new ErrorDataResult<List<Cv>>("Not ok");
	}
	
	@Override
	public DataResult<String> uploadCvPhoto(int cvId, MultipartFile file) throws IOException  {
	    if (!file.getContentType().toString().startsWith("image")) {
	    	return new ErrorDataResult<String>("Failed to load photo! The file is not an image.", file.getContentType());
	    } else if (!this.cvDao.existsById(cvId)) {
			return new ErrorDataResult<String>("Failed to load photo! Not found curriculum vitae.", null);
		} else {
			String image_url = this.cloudinaryService.upload(file).get("image_url").toString(); 
			Cv cv = this.cvDao.findById(cvId).get();
			cv.setImageUrl(image_url);
			this.cvDao.save(cv);
			return new SuccessDataResult<String>("Photo upload successfully.", image_url);
		}
	}
	

//	@Override
//	public DataResult<List<CurriculumVitaeDto>> getCurriculumVitaeDetails() {
//		return new SuccessDataResult<List<CurriculumVitaeDto>>(this.curriculumVitaeDao.getCurriculumVitaeDetails());
//	}

}