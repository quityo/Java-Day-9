package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public EducationManager(EducationDao educationDao, ModelMapper modelMapper, DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<EducationDto>> getAll() {
        return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(),EducationDto.class),"Data Listelendi");
    }

    @Override
    public DataResult<EducationDto> add(EducationDto educationDto) {
        this.educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
        return new SuccessDataResult<EducationDto>(educationDto, "Okul Eklendi");


    }

    @Override
    public DataResult<List<EducationDto>> findAllByCvIdOrderByEndAtDesc(int cvId) {
        List<Education> educations = educationDao.findAllByCvIdOrderByEndAtDesc(cvId);
        return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educations,EducationDto.class));
    }
    //private List<EducationDto> educationToDto(List<Education> educations) {
       // return educations.stream().map(Education -> modelMapper.map(Education, EducationDto.class)).collect(Collectors.toList());
   // }
}