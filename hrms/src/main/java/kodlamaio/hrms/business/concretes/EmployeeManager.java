package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployerDao employerDao;
    @Autowired
    public EmployeeManager(EmployeeDao employeeDao,ValidationService validationService, EmployerDao employerDao) {
        this.employeeDao = employeeDao;
        this.employerDao= employerDao;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>( this.employeeDao.findAll(),"Sistem Kullanıcıları Listelendi");
    }

    @Override
    public Result add(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult("Ekleme Başarılı");
    }

    @Override
    public Result verifyEmployer(int employerId, boolean verified) {
        Employer emp = new Employer();
        emp = employerDao.getById(employerId);
        emp.setVerified(verified);
        employerDao.save(emp);
        if(verified){
            return new SuccessResult("Kullanıcı Aktif Edildi"+emp.getCompanyName());
        }
        return new SuccessResult("Kullanıcı Pasif Edildi"+emp.getCompanyName());
    }

}