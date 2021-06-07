package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Explanation;

public interface ExplanationDao extends JpaRepository<Explanation,Integer> {
	List<Explanation> getByJobSeekerId(int jobSeekerId);
}