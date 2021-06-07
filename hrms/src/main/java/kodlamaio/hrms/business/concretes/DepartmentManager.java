package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public Result add(Department department) {
	
		Result result = BusinessRules.run(checkDepartment(department.getName()));

		if (result != null) {
			return result;
		}
		
		this.departmentDao.save(department);
		return new SuccessResult(Messages.departmentAdded);
	}

	@Override
	public Result delete(final Department department) {
		departmentDao.delete(department);

		return new SuccessResult(Messages.departmentDeleted);
	}

	@Override
	public Result update(final Department department) {
		departmentDao.save(department);

		return new SuccessResult(Messages.departmentUpdated);
	}
	
	
	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>
		(this.departmentDao.findAll(),"Departments listed");		
	}

	@Override
	public DataResult<Department> getById(final int id) {
		final Optional<Department> department = departmentDao.findById(id);

		if (department.isEmpty())
			new ErrorDataResult<Department>(Messages.departmentNotFound);

		return new SuccessDataResult<Department>(department.get());
	}
	
	private Result checkDepartment(String name) {
		
		var result = this.departmentDao.getByName(name);
		
		if (result != null) {
			return new ErrorResult(Messages.departmentCheck);
		}
		return new SuccessResult();
	}
}