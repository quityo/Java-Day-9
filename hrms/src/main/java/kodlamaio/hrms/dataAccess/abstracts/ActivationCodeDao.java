package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ActivationCodes;

public interface ActivationCodeDao extends JpaRepository<ActivationCodes, Integer>{
	List<ActivationCodes> findByUserId(Integer candidateId);
}