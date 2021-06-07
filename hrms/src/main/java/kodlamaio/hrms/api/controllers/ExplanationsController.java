package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExplanationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Explanation;

@RestController
@RequestMapping("/api/explanations")
public class ExplanationsController {
	
private ExplanationService explanationService;
	
	@Autowired
	public ExplanationsController(ExplanationService explanationService) {
		super();
		this.explanationService = explanationService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<Explanation>> getAll(){
		return this.explanationService.getAll();
		}
		
	@GetMapping("/getByJobSeeker")
	public DataResult<List<Explanation>> getAll(int jobSeekerId){
		return this.explanationService.getByJobSeekerId(jobSeekerId);
		}
		
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Explanation explanation){
	    return this.explanationService.add(explanation);
	    }
}
