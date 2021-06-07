package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer> {
	
	JobAnnouncement getById(int id);
	List<JobAnnouncement> getByEmployerId(int id);
	
	List<JobAnnouncement> getByIsActiveTrue();
	List<JobAnnouncement> getByApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAnnouncement> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAnnouncement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
}