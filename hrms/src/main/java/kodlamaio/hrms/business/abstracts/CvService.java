package kodlamaio.hrms.business.abstracts;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;

public interface CvService {
	DataResult<List<Cv>> getAll();
	
	Result add(Cv cv);
	
	DataResult<String> uploadCvPhoto(int cvId, MultipartFile file)throws IOException;
}
