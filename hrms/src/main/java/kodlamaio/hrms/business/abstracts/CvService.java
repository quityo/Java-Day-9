package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvService {

    DataResult<List<CvDto>> getAll();
    Result add(Cv cv);
    DataResult<List<Cv>> getAllJobseekerId(int id);
    Result saveImage(MultipartFile file, int cvId);

}
