package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;

public interface LanguageService {
	 DataResult<LanguageDto> add(LanguageDto languageDto);
	
	DataResult<List<Language>> getAll();
	}