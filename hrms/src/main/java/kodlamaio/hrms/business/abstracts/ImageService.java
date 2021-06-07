package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	Result add(MultipartFile file, Image image)throws IOException;
	DataResult<Image> getById(int id)throws IOException;
	DataResult<List<Image>> getByJobSeekerId(int jobSeekerId);

}
