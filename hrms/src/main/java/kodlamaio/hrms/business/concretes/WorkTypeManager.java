package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {


    private WorkTypeDao workTypeDao;

    @Autowired
    public WorkTypeManager(WorkTypeDao workTypeDao) {
        this.workTypeDao = workTypeDao;
    }
    @Override
    public DataResult<List<WorkType>> getAll() {
        return new SuccessDataResult<List<WorkType>>(workTypeDao.findAll(),"Çalışma Türleri Listelendi");
    }

    @Override
    public DataResult<WorkType> getById(int id) {
        return new SuccessDataResult<WorkType>(workTypeDao.getById(id),"Getirildi");
    }

    @Override
    public DataResult<WorkType> add(WorkType wayOfWorking) {
        this.workTypeDao.save(wayOfWorking);
        return new SuccessDataResult<WorkType>("Ekleme Başarılı");
    }
}