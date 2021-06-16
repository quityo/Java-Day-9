package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public  ExperienceManager( ExperienceDao experienceDao, DtoConverterService dtoConverterService) {
        this.experienceDao = experienceDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List< Experience>> getAll() {
        return new SuccessDataResult<List< Experience>>(this.experienceDao.findAll(), "Data Listelendi");
    }

    @Override
    public DataResult< ExperienceDto> add( ExperienceDto experienceDto) {
        this.experienceDao.save(( Experience) dtoConverterService.dtoClassConverter(experienceDto,  Experience.class));
        return new SuccessDataResult< ExperienceDto>(experienceDto, "İş Deneyimi Eklendi");
    }

    @Override
    public DataResult<List< ExperienceDto>> findAllByCvIdOrderByEndAt(int cvId) {
        List< Experience> experiences = experienceDao.findAllByCvIdOrderByEndAtDesc(cvId);
        return new SuccessDataResult<List< ExperienceDto>>(dtoConverterService.dtoConverter(experiences,  ExperienceDto.class));
    }
}