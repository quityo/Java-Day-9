package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface UserService{
	User add(User user);
//	Result update(User user);
//	Result delete(int id);
//	DataResult<User> getById(int id);
	
	DataResult<List<User>> getAll();
	DataResult<User> findUserByEmail(String email);
}