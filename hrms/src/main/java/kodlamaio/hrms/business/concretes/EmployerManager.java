package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
        return new SuccessResult("Employer has been added.");
	}
//
//	@Override
//	public void update(Employer employer) {
//		this.employerDao.save(employer);
//      return new SuccessResult("Employer has been updated.");
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.employerDao.deleteById(id);
//	    return new SuccessResult("Employer has been deleted.");
//	}
//
	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}



	/*
	 * private ActivationCodeService activationCodeService; private UserService
	 * userService;
	 * 
	 * public EmployerManager(EmployerDao employerDao, ActivationCodeService
	 * activationCodeService, UserService userService) { super(); this.employerDao =
	 * employerDao; this.activationCodeService = activationCodeService;
	 * this.userService = userService; }
	 * 
	 * @Override public DataResult<Employer> add(Employer employer) { // TODO
	 * Auto-generated method stub
	 * 
	 * if(!companyNameChecker(employer)) { return new
	 * ErrorDataResult<Employer>(null,"Şirket Adı Doldurulmak Zorundadır"); } else
	 * if(!webSiteChecker(employer)) { return new
	 * ErrorDataResult<Employer>(null,"WebSite Adresi Doldurulmak Zorundadır"); }
	 * else if(!isRealEmployer(employer)) { return new
	 * ErrorDataResult<Employer>(null,"Geçersiz Email Adresi"); } else
	 * if(!passwordNullChecker(employer)) { return new
	 * ErrorDataResult<Employer>(null,"Şifre Bilgisi Doldurulmak Zorundadır"); }
	 * else if(!isRealPhoneNumber(employer)) { return new
	 * ErrorDataResult<Employer>(null,"Telefon Numarası Geçersiz"); } else
	 * if(!isEmailAlreadyRegistered(employer)) { return new
	 * ErrorDataResult<Employer>(null,"Email Zaten Kayıtlı"); } User savedUser =
	 * this.userService.add(employer); this.activationCodeService.generateCode(new
	 * ActivationCodes(),savedUser.getId()); employer.setActivated(false); return
	 * new SuccessDataResult<Employer>(this.employerDao.save(employer)
	 * ,"İş Veren Hesabı Eklendi, Doğrulama Kodu Gönderildi ID:"+employer.getId());
	 * }
	 * 
	 * private boolean companyNameChecker(Employer employer) {
	 * if(employer.getCompanyName().isBlank() || employer.getCompanyName() == null)
	 * { return false; } return true; }
	 * 
	 * private boolean webSiteChecker(Employer employer) {
	 * if(employer.getWebsite().isBlank() || employer.getWebsite() == null) { return
	 * false; } return true; }
	 * 
	 * private boolean isRealEmployer(Employer employer) { String regex =
	 * "^(.+)@(.+)$"; Pattern pattern = Pattern.compile(regex); Matcher matcher =
	 * pattern.matcher(employer.getEmail()); if(!matcher.matches()) { return false;
	 * } else
	 * if(!employer.getEmail().contains(employer.getWebsite().substring(4,employer.
	 * getWebsite().length()-4))) { return false; } return true;
	 * 
	 * }
	 * 
	 * private boolean isEmailAlreadyRegistered(Employer employer) {
	 * if(employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
	 * return false; } return true; }
	 * 
	 * private boolean passwordNullChecker(Employer employer) {
	 * if(employer.getPassword().isBlank() || employer.getPassword() == null) {
	 * return false; } return true; }
	 * 
	 * private boolean isRealPhoneNumber(Employer employer) { String patterns =
	 * "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" +
	 * "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" +
	 * "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	 * 
	 * ÖRNEK TELEFON NUMARALARI String[] validPhoneNumbers =
	 * {"2055550125","202 555 0125", "(202) 555-0125", "+111 (202) 555-0125",
	 * "636 856 789", "+111 636 856 789", "636 85 67 89", "+111 636 85 67 89"};
	 * 
	 * Pattern pattern = Pattern.compile(patterns); Matcher matcher =
	 * pattern.matcher(employer.getPhoneNumber()); if(!matcher.matches()) { return
	 * false; } return true;
	 * 
	 * }
	 * 
	 */
	
	
	
}