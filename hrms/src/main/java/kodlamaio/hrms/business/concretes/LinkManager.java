package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {
	
	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}
	
	@Override
	public Result add(Link link) {
		var result = this.linkDao.save(link);
		if (result != null) {
			return new SuccessResult(Messages.linkAdded);
		}
		return new ErrorResult(Messages.linkNotAdded);
	}

	@Override
	public DataResult<List<Link>> getAll() {
		var result = this.linkDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Link>>(result,"links get ok");
		}
		return new ErrorDataResult<List<Link>>("Something is wrong");
	}

	@Override
	public DataResult<List<Link>> getByJobSeekerId(int jobSeekerId) {
		var result = this.linkDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Link>>(result);
		}
		return new ErrorDataResult<List<Link>>("Something is worng");
	}

}