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

import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkTime;

@CrossOrigin
@RestController
@RequestMapping("/api/worktimes")
public class WorkTimesController {
	
	private WorkTimeService workTimeService;
	@Autowired
	public WorkTimesController(WorkTimeService workTimeService) {
		this.workTimeService = workTimeService;
	}
	 @PostMapping("/add")
	 @ApiOperation("Add Work Time")
	 DataResult<WorkTime> add(@RequestBody WorkTime workTime) {
	        return workTimeService.add(workTime);

	 }

	 @GetMapping("/getbyid")
	 @ApiOperation("GetById Work Time")
	 DataResult<WorkTime> getById(@RequestParam("id") int id) {
	       return workTimeService.getById(id);

	 }

	 @GetMapping("/getall")
	 @ApiOperation("GetAll Work Times")
	 DataResult<List<WorkTime>> getAll() {
	       return workTimeService.getAll();

	    }
	

}
