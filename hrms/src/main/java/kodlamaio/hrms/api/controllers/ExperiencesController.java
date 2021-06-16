package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;

@RestController
@RequestMapping("/api/jobExperiences")
@CrossOrigin
@Api(value = "experience api documentation")
public class ExperiencesController {
	
	private ExperienceService experienceService;
	
	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ExperienceDto experience){
		return this.experienceService.add(experience);
	}
	
	@GetMapping("/getall")
    @ApiOperation("Get All Experience")
    DataResult<List<Experience>> getAll() {
        return this.experienceService.getAll();

    }
	
	 @GetMapping("/getCvExperiences")
	 public DataResult<List<ExperienceDto>> findAllByCvIdOrderByEndeAt(int cvId) {

	      return this.experienceService.findAllByCvIdOrderByEndAt(cvId);
	  }

	
	
}