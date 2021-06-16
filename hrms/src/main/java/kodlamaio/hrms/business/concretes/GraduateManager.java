package kodlamaio.hrms.business.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrms.entities.concretes.Graduate;

import java.util.List;
@Service
public class GraduateManager implements GraduateService {
    private GraduateDao graduateDao;

    @Autowired
    public GraduateManager(GraduateDao graduateDao) {
        this.graduateDao = graduateDao;
    }

    @Override
    public DataResult<List<Graduate>> getAll() {
        return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Graduate graduate) {
        this.graduateDao.save(graduate);
        return new SuccessResult("Ekleme Başarılı");
    }
}