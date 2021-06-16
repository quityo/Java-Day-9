package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Repository
public interface JobseekerDao extends JpaRepository<Jobseeker, Integer> {

	Jobseeker getByNationalId(String nationalId);
	Jobseeker getById(int id);
	Jobseeker findByFirstName(String title);
	List<Jobseeker> findAllByEmail(String email);
	 boolean existsBynationalId(String Tc);
}
