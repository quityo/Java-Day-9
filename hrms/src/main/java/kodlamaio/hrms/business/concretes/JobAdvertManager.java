package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import kodlamaio.hrms.entities.dtos.JobAdvertRequestDto;

import java.sql.Date;
import java.util.stream.Collectors;

@Service
public class JobAdvertManager implements JobAdvertService {
	private JobAdvertDao jobAdvertDao;
    private ModelMapper modelMapper;



    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao, ModelMapper modelMapper) {
        super();
        this.jobAdvertDao = jobAdvertDao;
        this.modelMapper = modelMapper;



    }

    @Override
    public DataResult<List<JobAdvertDto>> getAllAd() {
        List<JobAdvert> jobAdverts = jobAdvertDao.findAll();
        return  new SuccessDataResult<List<JobAdvertDto>>(jobAdvertToDto(jobAdverts), "Başarıyla Listelendi");
    }

    @Override
    public DataResult<JobAdvertRequestDto> addAd(JobAdvertRequestDto jobAdvert) {
    	JobAdvert jobAdverts = modelMapper.map(jobAdvert,JobAdvert.class);
    	jobAdvertDao.save(jobAdverts);

        return new SuccessDataResult<JobAdvertRequestDto>(jobAdvert, "İlan Eklendi");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getActive() {
        List<JobAdvert> jobAdverts = jobAdvertDao.findAllByActiveTrue();
        return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertToDto(jobAdverts), "Tüm Aktif İlanlar Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getEmpId(int id) {
        List<JobAdvert> jobAdverts = jobAdvertDao.findAllByEmployerIdAndActiveTrue(id);
        return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertToDto(jobAdverts), "Firmaya ait İş ilanları Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getAdDate() {
        List<JobAdvert> jobAdverts = jobAdvertDao.findAllByActiveTrueOrderByEndDateDesc();
        return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertToDto(jobAdverts), "Aktif İlanlar Tarihe Göre Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getAdCustomDate(Date date) {
        List<JobAdvert> jobAdverts = jobAdvertDao.findAllByCreatedAt(date);
        return new SuccessDataResult<List<JobAdvertDto>>(jobAdvertToDto(jobAdverts), "İstenilen Tarihe Göre Sıralandı");
    }

    @Override
    public DataResult<JobAdvert> updateActive(int id, boolean active) {
    	JobAdvert tempAdvert = jobAdvertDao.findById(id).orElse(null);
        tempAdvert.setActive(active);
        this.jobAdvertDao.save(tempAdvert);
        return new SuccessDataResult<JobAdvert>(tempAdvert, "Güncellendi");
    }
    private List<JobAdvertDto> jobAdvertToDto(List<JobAdvert> jobAdverts) {
        return jobAdverts.stream().map(Advert -> modelMapper.map(Advert, JobAdvertDto.class)).collect(Collectors.toList());
    }
}