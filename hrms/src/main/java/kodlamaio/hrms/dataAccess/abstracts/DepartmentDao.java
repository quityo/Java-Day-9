package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer>{
	Department getByName(String productName);
}