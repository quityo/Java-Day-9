package kodlamaio.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MailService;
import kodlamaio.hrms.business.abstracts.StaffService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.adapters.mernis.UserCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;
import kodlamaio.hrms.entities.dtos.JobSeekerRegisterDto;

@Service
public class AuthManager implements AuthService{

	private UserService userService;
	private JobSeekerService jobSeekerService;
	private MailService mailService;
	private EmployerService employerService;
	private UserCheckService checkPersonService;
	private ModelMapper modelMapper;
	private StaffService staffService;
	
	@Autowired
	public AuthManager(UserService userService, 
			JobSeekerService jobSeekerService,
			MailService mailService,
			EmployerService employerService,
			UserCheckService checkPersonService,
			ModelMapper modelMapper,
			StaffService staffService) {
		super();
		this.userService = userService;
		this.jobSeekerService = jobSeekerService;
		this.mailService = mailService;
		this.employerService = employerService;
		this.checkPersonService = checkPersonService;
		this.modelMapper = modelMapper;
		this.staffService = staffService;
		
	}

	@Override
	public Result employerRegister(EmployerRegisterDto employer) {
		
		var result = BusinessRules.run(
				 checkDomain(employer),
				 checkEmailVerification(employer.getEmail()),
				 checkStaffConfirm(),
				 checkIfEmailExists(employer.getEmail()),
				 checkPasswordSame(employer.getPassword(),employer.getRePassword())
				);
		if (result != null) {
			return result;
		}
		
        Employer createEmployer = modelMapper.map(employer,Employer.class);
        this.employerService.add(createEmployer);
        return new SuccessResult(Messages.registrationCompleted);
	}

	@Override
	public Result jobSeekerRegister(JobSeekerRegisterDto jobSeeker){
		Result result = BusinessRules.run(
				checkMernis(jobSeeker),
				checkIfEmailExists(jobSeeker.getEmail()),
				checkNationalityId(jobSeeker.getNationalityId()),
				checkPasswordSame(jobSeeker.getPassword(),jobSeeker.getRePassword()),
				checkEmailVerification(jobSeeker.getEmail())				
				);
		
		if (result != null) {
			return result;
		}
		
		JobSeeker creteJobSeeker = modelMapper.map(jobSeeker, JobSeeker.class);
        this.jobSeekerService.add(creteJobSeeker);
		return new SuccessResult(Messages.registrationCompleted);
		
	}
	
	// check rules
	
	private Result checkIfEmailExists(String email) {
		
		Result result = this.userService.getByEmail(email);
		
		if (result.getMessage() != null) {
			return new ErrorResult(Messages.registrationCompleted);
		}
		return new SuccessResult();
	}
	
	private Result checkEmailVerification(String email) {
		
		Result result = this.mailService.verification(email);
		
		if (result == null) {
			return new ErrorResult(Messages.emailNotVerified);
		}
		
		return new SuccessResult();
	}
	
	private Result checkPasswordSame(String password, String rePassword) {
		
		if (!password.equals(rePassword)) {
			return new ErrorResult(Messages.passwordsNotMatch);
		}
		
		return new SuccessResult();
	}
	
	
	//for jobSeekers
		
	private Result checkMernis(JobSeekerRegisterDto jobSeeker) {
		 
		if(checkPersonService.validate(
				jobSeeker.getNationalityId(),
				jobSeeker.getYearOfBirth())== false) {
			return new ErrorResult(Messages.mernisActivationNotVerified);
		}
		return new SuccessResult() ;
	}
	
	private Result checkNationalityId(String nationalityId) {
		
		Result result = this.jobSeekerService.getByNationalityId(nationalityId);
		
		if (result.getMessage() != null) {
			return new ErrorResult(Messages.userAlredyRegistered);
		}
		return new SuccessResult() ;
	}
			
	//for Employer
	
	private Result checkDomain(EmployerRegisterDto employerRegisterDto) {
		
		String domain = employerRegisterDto.getEmail().split("@")[0];
		
		if(domain.equals(employerRegisterDto.getWebAddress())){
        	return new SuccessResult();
        }
		
        return new ErrorResult(Messages.companyEmail);
	}

	private Result checkStaffConfirm() {
		if(this.staffService.confirm() == null) {
			return new ErrorResult(Messages.companyStaff);
		}
		return new SuccessResult();
	}
	
}
	