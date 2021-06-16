package kodlamaio.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import kodlamaio.hrms.entities.dtos.JobAdvertRequestDto;

public interface JobAdvertService {

	DataResult<List<JobAdvertDto>> getAllAd();
    DataResult<JobAdvertRequestDto> addAd(JobAdvertRequestDto jobAdvert);


    DataResult<List<JobAdvertDto>> getActive();
    DataResult<List<JobAdvertDto>> getEmpId(int id);
    DataResult<List<JobAdvertDto>> getAdDate();
    DataResult<List<JobAdvertDto>> getAdCustomDate(Date date);
    DataResult<JobAdvert> updateActive(int id, boolean active);
}