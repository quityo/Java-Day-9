package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getByIsConfirm(boolean isConfirm);

	DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);

	DataResult<List<JobAdvert>> sortByReleaseDate();

	DataResult<List<JobAdvert>> getByCompanyName(String companyName);
	
	DataResult<JobAdvert> getById(int jobAdvertId);

	Result add(JobAdvertDto jobAdvertDto);

	Result updateIsConfirm(boolean isConfirm, int jobAdvertId);

	Result updateIsActive(boolean isActive, int userId, int jobAdvertId);
 
}