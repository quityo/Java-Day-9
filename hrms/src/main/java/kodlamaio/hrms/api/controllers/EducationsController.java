package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {


	private  EducationService  educationService;

	@Autowired
	public EducationsController(EducationService  educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education){
		return this.educationService.add(education);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Education education){
		return this.educationService.update(education);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.educationService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Education> getById(@RequestParam int id){
		return this.educationService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<Education>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam int id){
		return this.educationService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<Education>> getAllByJobseekerId(@RequestParam int id){
		return this.educationService.getAllByJobseekerId(id);
	}
}