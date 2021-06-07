package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;

	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	
	@Override
	public Result add(City city) {
		var result = this.cityDao.save(city);
		if (result != null) {
			return new SuccessResult(Messages.cityAdded);
		}
		return new ErrorResult(Messages.cityNotAdded);
	}


	@Override
	public DataResult<List<City>> getAll() {
		var result = this.cityDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<City>>(result,"OK");
		}
		return new ErrorDataResult<List<City>>("Something is wrong");
	}

}