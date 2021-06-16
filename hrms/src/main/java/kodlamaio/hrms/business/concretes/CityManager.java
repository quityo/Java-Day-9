package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager  implements CityService {

    public CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }
    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(cityDao.findAll(),"Şehirler Getirildi");
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(cityDao.getById(id));
    }

    @Override
    public DataResult<City> add(City city) {
        return new SuccessDataResult<City>(cityDao.save(city),"Şehir Kaydı Başarılı");
    }
}