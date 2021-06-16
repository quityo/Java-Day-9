package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.helpers.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Result add(MultipartFile file, Image image) throws IOException {
		Map<String,String> getImage = (Map<String,String>)cloudinaryService.uploadImageFile(file).getData();
		image.setUrl(getImage.get("url"));
		image.setUploadedAt(LocalDate.now());
		var result = this.imageDao.save(image);
		if(result != null) {
			return new SuccessResult(Messages.imageUploaded);
		}
		return new ErrorResult(Messages.imageNotUploaded);
	}

	@Override
	public DataResult<Image> getById(int id) {
		var result =  this.imageDao.getById(id);
		if(result != null) {
			return new SuccessDataResult<Image>(result);
		}
		return new ErrorDataResult<Image>("Image NOT Founded");
	}

	

	@Override
	public DataResult<List<Image>> getByUserId(int userId) {
		var result =  this.imageDao.getByUserId(userId);
		if (result != null) {
			return new SuccessDataResult<List<Image>>(this.imageDao.getByUserId(userId));
		}
		return new ErrorDataResult<List<Image>>("Image NOT Founded");
	}

}