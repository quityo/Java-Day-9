package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LetterDao;
import kodlamaio.hrms.entities.concretes.Letter;

@Service
public class LetterManager implements LetterService{

	private LetterDao letterDao;
	
	@Autowired
	public LetterManager(LetterDao letterDao) {
		super();
		this.letterDao = letterDao;
	}

	@Override
	public Result add(Letter letter) {
		this.letterDao.save(letter);
		return new SuccessResult("Cover letter has been added.");
	}

	@Override
	public Result update( Letter  letter) {
		this.letterDao.save(letter);
		return new SuccessResult("Cover letter has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.letterDao.deleteById(id);
        return new SuccessResult("Cover letter has been deleted.");
	}

	@Override
	public DataResult<Letter> getById(int id) {
		return new SuccessDataResult<Letter>(this.letterDao.getById(id));
	}

	@Override
	public DataResult<List<Letter>> getAll() {
		return new SuccessDataResult<List<Letter>>(this.letterDao.findAll());
	}

	@Override
	public DataResult<List<Letter>> getByJobseekerId(int jobseekerId) {
		var result = this.letterDao.getByJobseekerId(jobseekerId);
		if (result != null) {
			return new SuccessDataResult<List<Letter>>(result,"OK");
		}
		return new ErrorDataResult<List<Letter>>("NOT OK");
	}
}