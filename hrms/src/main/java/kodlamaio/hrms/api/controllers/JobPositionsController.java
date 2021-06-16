package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	
	@GetMapping("/getall")
    @ApiOperation(value = "Get All Method")
    DataResult<List<JobPosition>> getAll() {
        return jobPositionService.getAll();

    }

    @GetMapping("/getbyid")
    @ApiOperation(value = "Get Byid Method")
    DataResult<Optional<JobPosition>> getById(int id) {
        return this.jobPositionService.getById(id);

    }
    @PostMapping("/add")
    @ApiOperation(value = "Add Job Method")
    Result add(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.add(jobPosition);

    }
	@GetMapping("/getAllAsc")
	public DataResult<List<JobPosition>> getAllSorted(){
		return this.jobPositionService.getAllSorted();
	}
}