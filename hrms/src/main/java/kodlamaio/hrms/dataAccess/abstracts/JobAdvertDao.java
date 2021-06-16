package kodlamaio.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	List<JobAdvert> findAllByActiveTrue();
	List<JobAdvert> findAllByEmployerIdAndActiveTrue(int id);
	List<JobAdvert> findAllByActiveTrueOrderByEndDateDesc();
    List<JobAdvert> findAllByCreatedAt(Date date);
}
