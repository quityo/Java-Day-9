package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	List<JobAdvert> getByEmployer_CompanyName(String companyName);

	List<JobAdvert> getByIsConfirm(boolean isConfirm);

	List<JobAdvert> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	JobAdvert getById(int jobAdvertId);

	@Modifying
	@Transactional
	@Query("update JobAdvert u set u.isConfirm=:isConfirm where u.jobAdvertId=:jobAdvertId  ")
	void updateIsConfirm(boolean isConfirm, int jobAdvertId);

	@Modifying
	@Transactional
	@Query("update JobAdvert u set u.isActive=:isActive where u.jobAdvertId=:jobAdvertId  ")
	void updateIsActive(boolean isActive, int jobAdvertId);

}
