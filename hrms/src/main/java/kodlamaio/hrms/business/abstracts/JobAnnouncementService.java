package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementService {
	
	Result add(JobAnnouncement jobAnnouncement);
	
	DataResult<List<JobAnnouncement>> getAll();
	
	DataResult<List<JobAnnouncement>> getByEmployerId(int id);
	
	DataResult<JobAnnouncement> changeStatus(int employerId,int announcementId, boolean status);
	
	DataResult<List<JobAnnouncement>> getByIsActiveTrue();
	DataResult<List<JobAnnouncement>> getByApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	
	
}