package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDto;

@Service
public class SkillManager implements SkillService{
	    private SkillDao skillDao;
	    private DtoConverterService dtoConverterService;

	    @Autowired
	    public SkillManager(SkillDao skillDao,DtoConverterService dtoConverterService) {
	        this.skillDao = skillDao;
	        this.dtoConverterService = dtoConverterService;
	    }
	
	    @Override
	    public DataResult<SkillDto> add(SkillDto skillDto) {
	        this.skillDao.save((Skill) dtoConverterService.dtoClassConverter(skillDto, Skill.class));
	        return new SuccessDataResult<SkillDto>(skillDto, "Yetenek Eklendi");
	    }

	

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	

}