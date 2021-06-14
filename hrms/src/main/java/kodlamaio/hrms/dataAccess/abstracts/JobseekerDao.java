package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Repository
public interface JobseekerDao extends JpaRepository<Jobseeker, Integer> {

	Jobseeker getByNationalId(String nationalId);
	Jobseeker getById(int id);
	JobPosition findByFirstName(String title);
}
