package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.CvHelperService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;
    private CloudinaryService cloudinaryService;
    private CvHelperService cvHelperService;
    private DtoConverterService dtoConverterService;
    @Autowired
    public CvManager(CvDao cvDao, CloudinaryService cloudinaryService, CvHelperService cvHelperService, DtoConverterService dtoConverterService) {
        this.cvDao = cvDao;
        this.cloudinaryService = cloudinaryService;
        this.cvHelperService= cvHelperService;
        this.dtoConverterService =dtoConverterService;

    }

    @Override
    public DataResult<List<CvDto>> getAll() {
        return new SuccessDataResult<List<CvDto>>(dtoConverterService.dtoConverter(cvDao.findAll(),CvDto.class), "Data Listelendi");
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        this.cvHelperService.setAllCvId(cv.getEducations(), cv.getLanguages(), cv.getSkills(), cv.getExperiences(), cv);
        return new SuccessResult("ekleme başarılı");
    }

    @Override
    public DataResult<List<Cv>> getAllJobseekerId(int id) {
        return  new SuccessDataResult<List<Cv>>(cvDao.findAllByJobseeker_Id(id));
    }

    @Override
    public Result saveImage(MultipartFile imageFile, int cvId) {
        Map<String, String> uploader = (Map<String, String>)  cloudinaryService.uploadImageFile(imageFile).getData();
        String imageUrl= uploader.get("url");
        Cv cva = cvDao.findById(cvId).orElse(null);
        assert cva != null;
        Cv Cv = cvDao.getById(cvId);
        Cv.setImage(imageUrl);
        cvDao.save(Cv);
        return new SuccessResult("Kayıt Başarılı");
    }





}